package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/8 9:59
 */
@SuppressWarnings("AlibabaAvoidComplexCondition")
public class WiggleSubsequence {

    public static void main(String[] args) {
//        int[] nums = {1, 7, 4, 9, 2, 5};
//        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(wiggleMaxLength(nums));
    }

    private static int wiggleMaxLength(int[] nums) {
        int result = 1;

        int currDiff, preDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if ((currDiff > 0 && preDiff <= 0) || (currDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = currDiff;
            }
        }

        return result;
    }
}
