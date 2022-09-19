package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Objects;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
@SuppressWarnings({"DeprecatedIsStillUsed", "CommentedOutCode"})
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
        if (Objects.isNull(prices)) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                continue;
            }

            result += prices[i] - prices[i - 1];
        }

        return result;
    }

    @Deprecated
    private static int maxProfitByDp(int[] prices) {
        // dp[i][0]: 第i天不持有股票，所能获取到的最大利润
        // dp[i][1]：第i天持有股票，所能获取到的最大利润

        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        if (Objects.isNull(prices)) {
            return 0;
        }

        int length = prices.length;
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }

        return dp[0];
    }
}
