package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/9/23 下午7:49
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = {5};
//        int[] nums = {-1};
//        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 1;
//        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        int[] sumArray = new int[nums.length];
        double maxAverage = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    sum += nums[i + j];
                }
            } else {
                sum = sumArray[i - 1] + nums[i + (k - 1)] - nums[i - 1];
            }

            sumArray[i] = sum;
            double average = (double) sum / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }

        return maxAverage;
    }
}
