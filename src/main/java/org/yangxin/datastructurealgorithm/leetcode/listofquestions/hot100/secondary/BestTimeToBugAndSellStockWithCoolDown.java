package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/26 16:13
 */
public class BestTimeToBugAndSellStockWithCoolDown {

    public static void main(String[] args) {
//        int[] prices = {1, 2, 3, 0, 2};
//        int[] prices = {1};
        int[] prices = {1, 2, 4};

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        /*
            result[i][0]: 第i天不持有股票
            result[i][1]: 第i天持有股票
            result[i][2]: 第i天是冷却器
         */
        int length = prices.length;
        int[][] result = new int[length][3];

        result[0][0] = 0;
        result[0][1] = -prices[0];
        result[0][2] = 0;
        for (int i = 1; i < length; i++) {
            // 第i天不持有股票
            result[i][0] = Math.max(result[i - 1][0], result[i - 1][2]);

            // 第i天持有股票
            result[i][1] = Math.max(result[i - 1][0] - prices[i],
                    Math.max(result[i - 1][1], result[i - 1][2] - prices[i]));

            // 第i天是冷却期
            result[i][2] = result[i - 1][1] + prices[i - 1];
        }

        return Math.max(result[length - 1][1] + prices[length - 1],
                Math.max(result[length - 1][0], result[length - 1][2]));
    }
}
