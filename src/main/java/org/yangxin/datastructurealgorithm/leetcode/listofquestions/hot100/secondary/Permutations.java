package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/12 0:07
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] visited = new int[nums.length];

        backtrack(result, nums, tmp, visited);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            tmp.add(nums[i]);

            backtrack(result, nums, tmp, visited);

            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
