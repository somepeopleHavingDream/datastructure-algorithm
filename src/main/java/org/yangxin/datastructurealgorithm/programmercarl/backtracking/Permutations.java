package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 23:38
 */
public class Permutations {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {0, 1};
        int[] nums = {1};

        System.out.println(permute(nums));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> permute(int[] nums) {
        PATH.clear();
        RESULT.clear();

        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return RESULT;
    }

    private static void backtracking(int[] nums, boolean[] used) {
        // 终止条件
        if (PATH.size() == nums.length) {
            RESULT.add(new ArrayList<>(PATH));
            return;
        }

        // 单层循环逻辑
        for (int i = 0; i < nums.length; i++) {
            // 处理结点
            if (used[i]) {
                continue;
            }
            PATH.add(nums[i]);
            used[i] = true;

            // 递归
            backtracking(nums, used);

            // 回溯
            PATH.remove(PATH.size() - 1);
            used[i] = false;
        }
    }
}
