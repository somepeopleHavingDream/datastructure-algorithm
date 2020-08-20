package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 *
 * @author yangxin
 * 2020/08/20 16:35
 */
public class SpiralOrder {

    /**
     * 每次读一行，如果该行有非-1值，则输出该行非-1值，然后左旋90度;
     * 如果该行全为-1值，则继续读取下一行，碰到非-1值同上处理，直至读完全部矩阵行
     *
     * @param matrix 矩阵
     * @return 矩阵内元素按从外到里排序输出的数组
     */
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

        int count = 0;
        int[] result = new int[length * width];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] != -1) {
                    result[count++] = copy[0][j];
                    copy[i][j] = -1;
                }
            }
//            result[count++] = copy[0][i];
            leftRotate(copy, i);
        }

        return result;
    }

    private static void leftRotate(int[][] copy, int n) {
        int size = copy.length;

        int[][] tmp = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(copy[i], 0, tmp[i], 0, size);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (n + j + 1 < size) {
                    copy[i][j] = tmp[n + j + 1][size - i - 1];
                } else {
                    copy[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}
