package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/9/4 下午2:43
 */
public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        int[] nums = {1, 1};
//        int[] nums = {1, 2, 3};
        System.out.println(minMoves(nums));
    }

    private static int minMoves(int[] nums) {
        /*
            n-1个数同时加1
            -> 每次有一个数自身减一
            -> 数组最后的数只能是最小值
            -> 每个元素减去最小值求其和就是最小步数
         */

        Arrays.sort(nums);
        int min = nums[0];

        int steps = 0;
        for (int num : nums) {
            steps += num - min;
        }

        return steps;
    }
}
