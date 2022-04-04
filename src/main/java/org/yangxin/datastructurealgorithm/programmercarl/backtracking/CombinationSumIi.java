package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 12:00
 */
@SuppressWarnings("SameParameterValue")
public class CombinationSumIi {

    public static void main(String[] args) {
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates = {2, 5, 2, 1, 2};
        System.out.println(combinationSum2(candidates, 5));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        PATH.clear();
        RESULT.clear();

        Arrays.sort(candidates);
        backtracking(candidates, target, 0);

        return RESULT;
    }

    private static void backtracking(int[] sortedCandidates, int target, int start) {
        // 终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            RESULT.add(new ArrayList<>(PATH));
            return;
        }

        // 单层for循环逻辑
        for (int i = start; i < sortedCandidates.length && target - sortedCandidates[i] >= 0; i++) {
            // 处理结点
            if (i > start && sortedCandidates[i] == sortedCandidates[i - 1]) {
                continue;
            }

            PATH.add(sortedCandidates[i]);
            // 递归
            backtracking(sortedCandidates, target - sortedCandidates[i], i + 1);
            // 回溯
            PATH.remove(PATH.size() - 1);
        }
    }
}
