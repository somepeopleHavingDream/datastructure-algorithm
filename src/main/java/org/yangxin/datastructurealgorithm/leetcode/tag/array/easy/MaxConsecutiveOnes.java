package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/9/4 下午4:06
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};
//        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int consecutive = 0;

        for (int num : nums) {
            if (num == 1) {
                consecutive++;
                continue;
            }

            if (consecutive > maxConsecutive) {
                maxConsecutive = consecutive;
            }
            consecutive = 0;
        }

        return Math.max(consecutive, maxConsecutive);
    }
}
