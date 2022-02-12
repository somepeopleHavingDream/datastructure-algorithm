package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/2/12 22:24
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class RotateImage {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix) {
        // 先上下翻转
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i -1][j] = tmp;
            }
        }

        // 再对角翻转
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
