package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 23:38
 */
public class PermutationsIi {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {1, 2, 3};

        System.out.println(permuteUnique(nums));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> permuteUnique(int[] nums) {
        PATH.clear();
        RESULT.clear();

        Arrays.sort(nums);
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

        // 单层for循环逻辑
        for (int i = 0; i < nums.length; i++) {
            // 处理结点
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

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
