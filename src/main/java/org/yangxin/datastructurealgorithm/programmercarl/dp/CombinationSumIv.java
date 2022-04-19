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
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    continue;
                }

                dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }
}
