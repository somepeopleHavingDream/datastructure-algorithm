package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/9/14 下午9:31
 */
public class ArrayPartitionI {

    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
//        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int output = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            output += Math.min(nums[i], nums[i + 1]);
        }

        return output;
    }
}
