package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/19 21:07
 */
@SuppressWarnings("SameParameterValue")
public class CombinationSumIv {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {9};
        System.out.println(combinationSum4(nums, 3));
    }

    private static int combinationSum4(int[] nums, int target) {
        // dp[j]: 和为j的排列数
        int[] dp = new int[target + 1];

        // dp[j] += dp[j - nums[i]]
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int num : nums) {
                if (j < num) {
                    continue;
                }

                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
