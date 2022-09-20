package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Objects;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
@SuppressWarnings({"SameParameterValue", "AlibabaUndefineMagicConstant"})
public class BestTimeToBuyAndSellStockIv {

    public static void main(String[] args) {
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {2, 4, 1};
//        int[] prices = {3, 2, 6, 5, 0, 3};
//        int[] prices = {};
        // 6
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(2, prices));
    }

    private static int maxProfit(int k, int[] prices) {
        // dp[i][1]：第i天第1次拥有股票的最大现金量
        // dp[i][2]：第i天第1次不拥有股票的最大现金量
        // dp[i][3]：第i天第2次拥有股票的最大现金量
        // dp[i][4]：第i天第2次不拥有股票的最大现金量
        // dp[i][j]：第i天第j（j为奇数）次拥有股票的最大现金量
        // dp[i][j + 1]：第i天第j+1（j为奇数）次不拥有股票的最大现金量

        // j为奇数
        // dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i])
        // dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i])

        if (Objects.isNull(prices)) {
            return 0;
        }

        // 考虑先不优化k空间
        int[] dp = new int[2 * k + 1];
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1], -prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            for (int j = 3; j <= 2 * k - 1; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
            }
        }

        return dp[2 * k];
    }
}
