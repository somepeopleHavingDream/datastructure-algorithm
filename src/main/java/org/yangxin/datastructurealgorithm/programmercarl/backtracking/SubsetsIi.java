package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 21:51
 */
public class SubsetsIi {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2};
//        int[] nums = {0};
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(subsetsWithDup(nums));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        PATH.clear();
        RESULT.clear();

        Arrays.sort(nums);
        backtracking(nums, 0);
        return RESULT;
    }

    private static void backtracking(int[] nums, int start) {
        RESULT.add(new ArrayList<>(PATH));

        // 终止条件
        if (start >= nums.length) {
            return;
        }

        // 单层for循环逻辑
        for (int i = start; i < nums.length; i++) {
            // 处理结点
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            PATH.add(nums[i]);

            // 递归
            backtracking(nums, i + 1);
            // 回溯
            PATH.remove(PATH.size() - 1);
        }
    }
}
