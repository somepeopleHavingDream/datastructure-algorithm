package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author yangxin
 * 2022/2/14 19:45
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
