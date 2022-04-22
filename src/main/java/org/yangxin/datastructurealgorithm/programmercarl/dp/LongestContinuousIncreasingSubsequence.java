package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/22 11:46
 */
public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(findLengthOfLcisByDp(nums));
        System.out.println(findLengthOfLcisByGreedy(nums));
    }

    private static int findLengthOfLcisByGreedy(int[] nums) {
        int max = 1;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        return max;
    }

    private static int findLengthOfLcisByDp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            }

            dp[i] = dp[i - 1] + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
