package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Objects;

/**
 * @author yangxin
 * 2022/4/20 16:42
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode", "DeprecatedIsStillUsed"})
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
        // 用贪心法
        int left = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            left = Math.min(left, price);
            result = Math.max(result, price - left);
        }

        return result;
    }

    /**
     * 优先贪心，不建议滚动数组
     *
     * @param prices 股票当日价格
     * @return 最大收益
     */
    @Deprecated
    private static int maxProfitByDp(int[] prices) {
        // 用动态规划法（滚动数组）
        // dp[i][0]：第i天未持有股票所获得的最大收益
        // dp[i][1]：第i天持有股票所获得的最大收益
        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        if (Objects.isNull(prices)) {
            return 0;
        }

        int[] dp = new int[2];

        dp[1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }

        return dp[0];
    }
}
