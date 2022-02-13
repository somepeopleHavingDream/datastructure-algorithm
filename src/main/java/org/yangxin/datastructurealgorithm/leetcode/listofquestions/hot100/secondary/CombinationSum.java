package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/13 14:08
 */
@SuppressWarnings("CommentedOutCode")
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

//        int[] candidates = {2, 3, 5};
//        int target = 8;

        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int startIndex = 0;
        combinate(candidates, target, result, tmp, startIndex);

        return result;
    }

    private static void combinate(int[] candidates,
                                  int target,
                                  List<List<Integer>> result,
                                  List<Integer> tmp,
                                  int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            combinate(candidates, target - candidates[i], result, tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
