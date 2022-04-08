package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 22:50
 */
@SuppressWarnings({"AlibabaAvoidComplexCondition", "AlibabaUndefineMagicConstant"})
public class IncreasingSubsequences {

    public static void main(String[] args) {
//        int[] nums = {4, 6, 7, 7};
        int[] nums = {4, 4, 3, 2, 1};
        System.out.println(findSubsequences(nums));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> findSubsequences(int[] nums) {
        PATH.clear();
        RESULT.clear();

        backtracking(nums, 0);
        return RESULT;
    }

    private static void backtracking(int[] nums, int start) {
        if (PATH.size() >= 2) {
            RESULT.add(new ArrayList<>(PATH));
        }

        // 终止条件
        if (start >= nums.length) {
            return;
        }

        // 单层循环逻辑
        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            // 处理结点
            if ((PATH.size() != 0 && nums[i] < PATH.get(PATH.size() - 1))
                    || used[nums[i] + 100] == 1) {
                continue;
            }
            PATH.add(nums[i]);
            used[nums[i] + 100] = 1;

            // 递归
            backtracking(nums, i + 1);
            // 回溯
            PATH.remove(PATH.size() - 1);
        }
    }
}
