package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Objects;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode", "CommentedOutCode"})
public class BestTimeToBuyAndSellStockIii {

    public static void main(String[] args) {
//        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        // dp[i][0]：在第i天初次不持有股票的最大现金量
        // dp[i][1]：在第i天第1次持有股票的最大现金量
        // dp[i][2]：在第i天第1次不持有股票的最大现金量
        // dp[i][3]：在第i天第2次持有股票的最大现金量
        // dp[i][4]：在第i天第2次不持有股票的最大现金量

        // dp[i][0] = dp[i - 1][0];
        // dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        // dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
        // dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
        // dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);

        if (Objects.isNull(prices)) {
            return 0;
        }

        int[] dp = new int[5];
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;
        dp[3] = -prices[0];
        dp[4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[0] - prices[i], dp[1]);
            dp[2] = Math.max(dp[1] + prices[i], dp[2]);
            dp[3] = Math.max(dp[2] - prices[i], dp[3]);
            dp[4] = Math.max(dp[3] + prices[i], dp[4]);
        }

        return Math.max(dp[2], dp[4]);
    }
}
