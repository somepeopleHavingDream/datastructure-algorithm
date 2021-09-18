package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangxin
 * 2021/9/16 下午9:22
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};

        // 期待6
//        int[] nums = {1, 2, 1, 3, 0, 0, 2, 2, 1, 3, 3};

        // 期待2
//        int[] nums = {1, 4, 1, 3, 1, -14, 1, -13};
        System.out.println(findLHS(nums));
    }

    private static int findLHS(int[] nums) {
        int longest = 0, positiveLongest = 1, negativeLongest = 1;
        boolean positiveFlag = false, negativeFlag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < longest) {
                return longest;
            }

            for (int j = i + 1; j < nums.length; j++) {
                int abs = nums[i] - nums[j];
                if (abs == 0) {
                    positiveLongest++;
                    negativeLongest++;
                } else if (abs == 1) {
                    positiveLongest++;
                    positiveFlag = true;
                } else if (abs == -1) {
                    negativeLongest++;
                    negativeFlag = true;
                }
            }

            int currentLongest = 0;
            if (positiveFlag) {
                currentLongest = Math.max(positiveLongest, currentLongest);
            }
            if (negativeFlag) {
                currentLongest = Math.max(negativeLongest, currentLongest);
            }

            longest = Math.max(currentLongest, longest);
            positiveFlag = false;
            negativeFlag = false;
            positiveLongest = 1;
            negativeLongest = 1;

        }

        return longest;
    }
}
