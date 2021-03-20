package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/3/19 下午9:28
 */
@SuppressWarnings("CommentedOutCode")
public class SquaresOfSortedArray {

    public static int[] sortedSquares1(int[] nums) {
        if (nums == null) {
            return new int[0];
        }

        int minAbs = Math.abs(nums[0]);
        int minAbsIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < minAbs) {
                minAbs = Math.abs(nums[i]);
                minAbsIndex = i;
            }
        }

        int backward = minAbsIndex, forward = minAbsIndex + 1;
        int[] newNums = new int[nums.length];
        int i = 0;
        while (backward >= 0 && forward < nums.length) {
            if (Math.abs(nums[backward]) < Math.abs(nums[forward])) {
                newNums[i++] = (int) Math.pow(nums[backward--], 2);
            } else {
                newNums[i++] = (int) Math.pow(nums[forward++], 2);
            }
        }

        while (backward >= 0) {
            newNums[i++] = (int) Math.pow(nums[backward--], 2);
        }
        while (forward < nums.length) {
            newNums[i++] = (int) Math.pow(nums[forward++], 2);
        }

        return newNums;
    }

    public static int[] sortedSquares2(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(newNums);

        return newNums;
    }

    public static int[] sortedSquares3(int[] nums) {
        int[] newNums = new int[nums.length];
        int forward = 0, backward = nums.length - 1, i = nums.length - 1;
        while (forward <= backward) {
            if (Math.pow(nums[forward], 2) > Math.pow(nums[backward], 2)) {
                newNums[i--] = (int) Math.pow(nums[forward++], 2);
            } else {
                newNums[i--] = (int) Math.pow(nums[backward--], 2);
            }
        }

        return newNums;
    }

    public static void main(String[] args) {
//        testSortedSquares1();
//        testSortedSquares2();

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares3(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares3(nums2)));
    }

    private static void testSortedSquares2() {
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares2(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares2(nums2)));
    }

    private static void testSortedSquares1() {
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares1(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares1(nums2)));

        int[] nums3 = {0, 2};
        System.out.println(Arrays.toString(sortedSquares1(nums3)));

        int[] nums4 = {-5, -3, -2, -1};
        System.out.println(Arrays.toString(sortedSquares1(nums4)));
    }
}
