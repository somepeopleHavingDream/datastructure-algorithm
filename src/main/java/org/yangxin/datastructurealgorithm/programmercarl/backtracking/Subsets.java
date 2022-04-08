package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 19:10
 */
public class Subsets {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {0};
        System.out.println(subsets(nums));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> subsets(int[] nums) {
        PATH.clear();
        RESULT.clear();

        backtracking(nums, 0);
        return RESULT;
    }

    private static void backtracking(int[] nums, int start) {
        RESULT.add(new ArrayList<>(PATH));

        // 终止条件
        if (start >= nums.length) {
            return;
        }

        // 单层循环逻辑
        for (int i = start; i < nums.length; i++) {
            // 处理结点
            PATH.add(nums[i]);
            // 递归
            backtracking(nums, i + 1);
            // 回溯
            PATH.remove(PATH.size() - 1);
        }
    }
}
