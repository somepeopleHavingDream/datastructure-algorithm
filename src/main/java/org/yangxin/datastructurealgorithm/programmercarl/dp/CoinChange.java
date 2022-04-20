package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/19 21:52
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
//        int[] coins = {2};
//        int[] coins = {1};
        System.out.println(coinChange(coins, 11));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}