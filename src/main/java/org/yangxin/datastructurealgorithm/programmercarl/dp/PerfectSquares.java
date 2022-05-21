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
        // dp[j]: 和为j的最小平方和的个数
        int[] dp = new int[n + 1];

        // dp[j] = Math.min(dp[j], dp[j - i * i] + 1)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }
}
