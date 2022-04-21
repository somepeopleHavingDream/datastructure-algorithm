package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
//        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices = {1, 3, 7, 5, 10, 3};
        System.out.println(maxProfit(prices, 3));
    }

    private static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[prices.length - 1][1];
    }
}
