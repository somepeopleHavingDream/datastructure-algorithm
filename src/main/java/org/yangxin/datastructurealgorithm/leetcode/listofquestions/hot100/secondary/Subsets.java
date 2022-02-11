package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/10 22:44
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int all = result.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(num);
                result.add(tmp);
            }
        }

        return result;
    }
}
