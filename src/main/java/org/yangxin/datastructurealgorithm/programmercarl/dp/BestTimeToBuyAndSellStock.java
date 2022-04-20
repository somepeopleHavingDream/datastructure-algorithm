package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
        int[] prices = {1, 2};
        System.out.println(maxProfitByGreedy(prices));
        System.out.println(maxProfitByDp(prices));
    }

    /*
        显然，贪心算法的性能比动态规划的好
     */

    private static int maxProfitByGreedy(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            low = Math.min(low, price);
            result = Math.max(result, price - low);
        }

        return result;
    }

    private static int maxProfitByDp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
