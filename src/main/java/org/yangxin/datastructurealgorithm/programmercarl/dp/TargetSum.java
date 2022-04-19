package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/19 9:27
 */
public class TargetSum {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 1, 1};
        int[] nums = {1};
        System.out.println(findTargetSumWays(nums, 1));
    }

    private static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((target + sum) % 2 == 1) {
            return 0;
        }

        return dp(nums, (target + sum) / 2);
    }

    private static int dp(int[] nums, int additiveSum) {
        int[] dp = new int[additiveSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = additiveSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[additiveSum];
    }
}
