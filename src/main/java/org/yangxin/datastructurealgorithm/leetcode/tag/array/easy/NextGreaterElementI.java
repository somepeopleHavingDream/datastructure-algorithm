package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/9/7 下午10:14
 */
@SuppressWarnings("StatementWithEmptyBody")
public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
//        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 2, 3, 4};
//        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            for (; j < nums2.length && nums2[j] != nums1[i]; j++) {}
            for (j = j + 1; j < nums2.length && nums2[j] < nums1[i]; j++) {}
            nums1[i] = j == nums2.length ? -1 : nums2[j];
        }

        return nums1;
    }
}
