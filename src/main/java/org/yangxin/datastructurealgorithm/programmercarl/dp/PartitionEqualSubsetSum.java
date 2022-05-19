package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/18 16:42
 */
@SuppressWarnings({"AlibabaUndefineMagicConstant", "DuplicatedCode"})
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        // dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i])

        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }

        return dp[bagSize] == bagSize;
    }
}
