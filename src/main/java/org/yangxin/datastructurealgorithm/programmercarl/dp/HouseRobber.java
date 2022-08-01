package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 15:35
 */
public class HouseRobber {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {0};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        // dp[i]: 偷窃到第i间屋子时的最高金额
        int[] dp = new int[length];

        // dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1])
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[length - 1];
    }
}
