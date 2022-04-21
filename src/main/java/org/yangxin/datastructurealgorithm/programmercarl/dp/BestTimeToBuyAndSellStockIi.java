package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
public class BestTimeToBuyAndSellStockIi {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfitByGreedy(prices));
        System.out.println(maxProfitByDp(prices));
    }

    /*
        显然，贪心算法的性能比动态规划的好
     */

    private static int maxProfitByGreedy(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    private static int maxProfitByDp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
