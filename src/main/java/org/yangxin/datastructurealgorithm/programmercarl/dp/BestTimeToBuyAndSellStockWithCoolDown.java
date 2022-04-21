package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
public class BestTimeToBuyAndSellStockWithCoolDown {

    public static void main(String[] args) {
//        int[] prices = {1, 2, 3, 0, 2};
//        int[] prices = {1};

        // 3
        int[] prices = {1, 2, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][3];

        /*
            卖出股票后，才有冷冻期
         */

        // 第0天，持有股票
        dp[0][0] = -prices[0];
        // 第0天，不持有股票，但并不是今天卖出的
        dp[0][1] = 0;
        // 第0天，不持有股票，因为今天卖出股票
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    private static int max(int... array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
        return max;
    }
}
