package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 *
 * @author yangxin
 * 2020/09/03 10:33
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        // 要求时间复杂度为o(n)，则是只对数组一次遍历
        // 断言此入参数组的长度不为0
        int maxSum = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= maxSum) {
                maxSum = sum;
            }
            // 如果加上当前元素使的和为负数，说明可以抛弃当前元素
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
//        int[] nums = {-1};
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
