package org.yangxin.datastructurealgorithm.programmercarl.array;

/**
 * @author yangxin
 * 2022/3/3 21:08
 */
@SuppressWarnings("SameParameterValue")
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 4, 4};
//        int[] nums ={1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println(minSubArrayLen(7, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int i = 0, j = 0, sum = 0;
        for (; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
