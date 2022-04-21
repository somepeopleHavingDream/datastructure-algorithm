package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
public class BestTimeToBuyAndSellStockIv {

    public static void main(String[] args) {
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {2, 4, 1};
//        int[] prices = {3, 2, 6, 5, 0, 3};
        int[] prices = {};
        System.out.println(maxProfit(2, prices));
    }

    private static int maxProfit(int k, int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2 * k + 1];

        // 初始化第0天买入的最大现金值
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                dp[i][j + 1] = Math.max(dp[i - 1][j] + prices[i], dp[i - 1][j + 1]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
