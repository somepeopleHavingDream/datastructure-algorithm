package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/18 16:42
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        // 求和
        int sum = Arrays.stream(nums).sum();

        // 如果是奇数
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        return dp(nums, target) == target;
    }

    private static int dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }

        return dp[target];
    }
}
