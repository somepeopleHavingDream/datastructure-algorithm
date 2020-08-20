package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 顺时针打印矩阵
 *
 * @author yangxin
 * 2020/08/20 16:35
 */
public class SpiralOrder {

    public static int[] spiralOrder(int[][] matrix) {
        int length = matrix[0].length;
        int width = matrix.length;
        int size = Math.max(length, width);

        int[][] copy = new int[size][size];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (i < width && j < length) {
                    copy[i][j] = matrix[i][j];
                } else {
                    copy[i][j] = -1;
                }
            }
        }

        int[] result = new int[length * width];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] != -1) {
                    result[i] = copy[i][j];
                    copy[i][j] = -1;
                }
            }
            leftRotate(copy);
        }

        return result;
    }

    private static void leftRotate(int[][] copy) {
        int size = copy.length;
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                copy[size - j - 1][i] = copy[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}
