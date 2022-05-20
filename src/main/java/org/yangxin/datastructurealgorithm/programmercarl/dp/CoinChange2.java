package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/19 11:34
 */
public class CoinChange2 {

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int[] coins = {2};
        int[] coins = {10};
        System.out.println(change(10, coins));
    }

    private static int change(int amount, int[] coins) {
        // dp[j]: 凑成金额为j的硬币组合数
        int[] dp = new int[amount + 1];

        // dp[j] += dp[j - coins[i]]
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
