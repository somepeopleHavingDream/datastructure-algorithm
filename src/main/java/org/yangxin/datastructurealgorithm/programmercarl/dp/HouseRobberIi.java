package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/20 15:35
 */
@SuppressWarnings({"DuplicatedCode", "AlibabaUndefineMagicConstant"})
public class HouseRobberIi {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {1, 2, 3};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // dp[i]: 偷窃到第i间屋子的最高金额
        // dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1])
        int[] dp = new int[3];
        return Math.max(calc(nums, 0, length - 2, dp), calc(nums, 1, length - 1, dp));
    }

    private static int calc(int[] nums, int start, int end, int[] dp) {
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        if (start + 2 > end) {
            return Math.max(dp[0], dp[1]);
        }

        for (int i = start + 2; i <= end; i++) {
            dp[2] = Math.max(nums[i] + dp[0], dp[1]);

            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }
}
