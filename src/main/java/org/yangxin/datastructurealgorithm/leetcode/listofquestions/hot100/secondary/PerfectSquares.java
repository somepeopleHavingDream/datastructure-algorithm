package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/2/26 12:27
 */
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    private static int numSquares(int n) {
        int[] result = new int[n + 1];

        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, result[i - j * j]);
            }

            result[i] = 1 + min;
        }

        return result[n];
    }
}
