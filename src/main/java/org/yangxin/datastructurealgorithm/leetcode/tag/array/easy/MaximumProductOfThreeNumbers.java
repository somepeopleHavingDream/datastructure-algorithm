package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/3/21 上午10:17
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class MaximumProductOfThreeNumbers {

    public static int maximumProduct1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[nums.length -1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static int maximumProduct2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int maxProduct1 = Integer.MIN_VALUE, maxProduct2 = Integer.MIN_VALUE, maxProduct3 = Integer.MIN_VALUE;
        int minProduct1 = Integer.MAX_VALUE, minProduct2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > maxProduct1) {
                maxProduct3 = maxProduct2;
                maxProduct2 = maxProduct1;
                maxProduct1 = num;
            } else if (num > maxProduct2) {
                maxProduct3 = maxProduct2;
                maxProduct2 = num;
            } else if (num > maxProduct3) {
                maxProduct3 = num;
            }

            if (num < minProduct1) {
                minProduct2 = minProduct1;
                minProduct1 = num;
            } else if (num < minProduct2) {
                minProduct2 = num;
            }
        }

        return Math.max(minProduct1 * minProduct2 * maxProduct1, maxProduct1 * maxProduct2 * maxProduct3);
    }

    public static void main(String[] args) {
//        testMaximumProduct1();

        testMaximumProduct2();
    }

    private static void testMaximumProduct2() {
        int[] nums1 = {1, 2, 3};
        System.out.println(maximumProduct2(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(maximumProduct2(nums2));

        int[] nums3 = {-1, -2, -3};
        System.out.println(maximumProduct2(nums3));
    }

    private static void testMaximumProduct1() {
        int[] nums1 = {1, 2, 3};
        System.out.println(maximumProduct1(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(maximumProduct1(nums2));

        int[] nums3 = {-1, -2, -3};
        System.out.println(maximumProduct1(nums3));

        int[] nums4 = {-100, -98, -1, 2, 3, 4};
        System.out.println(maximumProduct1(nums4));
    }
}
