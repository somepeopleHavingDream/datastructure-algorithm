package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/3 12:22
 */
@SuppressWarnings("SameParameterValue")
public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return RESULT;
    }

    private static void backtracking(int n, int k, int start) {
        // 编写终止条件
        if (PATH.size() == k) {
            RESULT.add(new ArrayList<>(PATH));
            return;
        }

        // 编写for循环逻辑
        for (int i = start; k - PATH.size() <= n - i + 1; i++) {
            PATH.add(i);
            backtracking(n, k, i + 1);
            PATH.remove(PATH.size() - 1);
        }
    }
}
