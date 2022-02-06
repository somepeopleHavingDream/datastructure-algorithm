package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 *
 * @author yangxin
 * 2020/08/20 16:35
 */
public class SpiralOrder {

    /**
     * 每次读一行，如果该行有非Integer.MAX_VALUE值，则输出该行非Integer.MAX_VALUE值，然后左旋90度;
     * 如果该行全为Integer.MAX_VALUE值，则继续读取下一行，碰到非Integer.MAX_VALUE值同上处理，直至读完全部矩阵行
     *
     * @param matrix 矩阵
     * @return 矩阵内元素按从外到里排序输出的数组
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // 原矩阵的长
        int length = matrix[0].length;
        // 原矩阵的宽
        int width = matrix.length;
        // 计算正方形矩阵的边长，取原矩阵长宽中的最大值
        int size = Math.max(length, width);

        // 构建正方形矩阵
        int[][] copy = new int[size][size];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (i < width && j < length) {
                    copy[i][j] = matrix[i][j];
                } else {
                    copy[i][j] = Integer.MAX_VALUE;
//                    copy[i][j] = -1;
                }
            }
        }

        // 读数据
        int[] result = new int[length * width];
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            // 对一行的数据进行处理
            // 这里有两种情况，第1种情况：当前行无数据、第2种情况：当前行有数据
            for (int j = 0; j < size; j++) {
                if (copy[i][j] != Integer.MAX_VALUE) {
//                if (copy[i][j] != -1) {
                    result[count++] = copy[i][j];
                    copy[i][j] = Integer.MAX_VALUE;
//                    copy[i][j] = -1;

                    // 代表该行有读取到的数据
                    flag = true;
                }
            }

            // 如果那一行读取到了数据，则进行翻转，否则继续读取下一行数据
            if (flag) {
//                i--;
                i = -1;
                leftRotate(copy, size);
                flag = false;
            }
        }

        return result;
    }

    /**
     * 将矩阵左旋转90度
     */
    private static void leftRotate(int[][] copy, int size) {
        // 将copy矩阵复制一份存入到origin中，以备用
        int[][] origin = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(copy[i], 0, origin[i], 0, size);
        }

        // 行列翻转
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = origin[j][size - 1 -i];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 5}, {8, 4}, {0, -1}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}
