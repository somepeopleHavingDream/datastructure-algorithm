package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Objects;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
@SuppressWarnings({"CommentedOutCode", "AlibabaRemoveCommentedCode"})
public class BestTimeToBuyAndSellStockWithCoolDown {

    public static void main(String[] args) {
//        int[] prices = {1, 2, 3, 0, 2};
//        int[] prices = {1};

        // 3
        int[] prices = {1, 2, 4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        // dp[i][0]：第i天持有股票的最大金额量
        // dp[i][1]：第i天不持有股票（当天卖掉股票）的最大金额量
        // dp[i][2]：第i天不持有股票（非当天卖掉股票）的最大金额量

        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
        // dp[i][1] = dp[i - 1][0] + prices[i];
        // dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);

        if (Objects.isNull(prices)) {
            return 0;
        }

        int[] dp = new int[3];
        dp[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int oldDp0 = dp[0];
            int oldDp1 = dp[1];
            dp[0] = Math.max(dp[0], dp[2] - prices[i]);
            dp[1] = oldDp0 + prices[i];
            dp[2] = Math.max(dp[2], oldDp1);
        }

        return Math.max(dp[1], dp[2]);
    }
}
