package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 15:35
 */
public class HouseRobberIi {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 2};
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 3};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    private static int robRange(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);

        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[right];
    }
}
