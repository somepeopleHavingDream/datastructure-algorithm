package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

import java.util.Arrays;

/**
 * 数组中重复的数字
 *
 * @author yangxin
 * 2020/07/24 09:54
 */
public class FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        // 先升序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
