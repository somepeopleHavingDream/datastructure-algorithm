package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/14 21:55
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs2(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    private static int minCostClimbingStairs2(int[] cost) {
        /*
            每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯
         */
        // dp[i]: 到达楼层i所需要的最少花费
        // dp[i] = Math.min(dp[0], dp[1]) + cost[i]
        int[] dp = new int[2];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int min = Math.min(dp[0], dp[1]) + cost[i];
            dp[0] = dp[1];
            dp[1] = min;
        }

        return Math.min(dp[0], dp[1]);
    }
}
