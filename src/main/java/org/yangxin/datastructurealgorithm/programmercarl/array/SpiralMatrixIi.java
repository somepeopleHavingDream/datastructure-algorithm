package org.yangxin.datastructurealgorithm.programmercarl.array;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/3/6 20:13
 */
public class SpiralMatrixIi {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;

        int loop = n / 2;
        while (loop > 0) {
            loop--;

            int i = startX;
            int j = startY;

            // 上边，从左到右
            for (; j < startY + n - offset; j++) {
                matrix[startX][j] = count++;
            }

            // 右边，从上到下
            for (; i < startX + n - offset; i++) {
                matrix[i][j] = count++;
            }

            // 下边，从右到左
            for (; j > startY ; j--) {
                matrix[i][j] = count++;
            }

            // 左边，从下到上
            for (; i > startX; i--) {
                matrix[i][j] = count++;
            }

            startX++;
            startY++;
            offset += 2;
        }

        int mid = n / 2;
        if (n % 2 == 1) {
            matrix[mid][mid] = count;
        }

        return matrix;
    }
}
