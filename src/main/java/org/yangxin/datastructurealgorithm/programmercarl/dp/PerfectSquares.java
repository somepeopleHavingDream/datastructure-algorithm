package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/20 10:23
 */
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    private static int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (j - i * i < 0) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        // 按照题目的意思，一定是有正常结果的
        return dp[n];
    }
}
