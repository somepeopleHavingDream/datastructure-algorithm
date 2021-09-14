package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangxin
 * 2021/9/14 下午9:42
 */
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
//        int r = 2, c = 4;
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }

    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int[] i : mat) {
            for (int j : i) {
                queue.offer(j);
            }
        }

        int[][] output = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                output[i][j] = queue.remove();
            }
        }

        return output;
    }
}
