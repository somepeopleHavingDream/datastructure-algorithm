package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/3/19 下午8:28
 */
public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        // 入参校验
        if (matrix == null) {
            return new int[0][];
        }

        // 获得新矩阵的列数
        int newColumnNum = matrix.length;
        // 新矩阵的行数
        int newRowNum = matrix[0].length;

        // 分配新的矩阵空间
        int[][] newMatrix = new int[newRowNum][newColumnNum];

        // 为新矩阵赋值
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(transpose(matrix1)));

        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(transpose(matrix2)));
    }
}
