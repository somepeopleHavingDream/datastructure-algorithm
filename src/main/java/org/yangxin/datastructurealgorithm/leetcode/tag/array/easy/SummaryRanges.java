package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2021/3/21 下午3:37
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> resultList = new LinkedList<>();
        int prev = 0, i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }

            String tmp;
            if (i - prev == 1) {
                tmp = String.valueOf(nums[prev]);
            } else {
                tmp = nums[prev] + "->" + nums[i - 1];
            }

            resultList.add(tmp);
            prev = i;
        }

        if (i == nums.length) {
            String tmp;
            if (i - 1 == prev) {
                tmp = String.valueOf(nums[prev]);
            } else {
                tmp = nums[prev] + "->" + nums[i - 1];
            }
            resultList.add(tmp);
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums1));

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums2));

        int[] nums3 = {};
        System.out.println(summaryRanges(nums3));

        int[] nums4 = {-1};
        System.out.println(summaryRanges(nums4));

        int[] nums5 = {0};
        System.out.println(summaryRanges(nums5));
    }
}
