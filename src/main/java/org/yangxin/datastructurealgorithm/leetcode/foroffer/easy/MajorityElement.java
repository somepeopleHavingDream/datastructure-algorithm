package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author yangxin
 * 2020/09/02 10:23
 */
public class MajorityElement {

    /**
     * 数组是非空的，并且给定的数组总是存在多数元素
     */
    public static int majorityElement(int[] nums) {
        // 先升序
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                count = 1;
            } else {
                count++;
            }

            if (count > nums.length / 2) {
                return nums[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 3};
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
