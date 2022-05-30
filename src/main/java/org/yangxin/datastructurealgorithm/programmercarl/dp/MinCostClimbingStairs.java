package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/14 21:55
 */
@SuppressWarnings("ConstantConditions")
public class MinCostClimbingStairs {

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
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
        // dp[i]: 到达楼层i所需要的最少花费
        // dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            int sum = Math.min(dp[0] + cost[i - 1], dp[1] + cost[i - 2]);
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }
}
