package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/3 13:26
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class CombinationSumIii {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
    }

    private static final List<Integer> PATH = new LinkedList<>();
    private static final List<List<Integer>> RESULT = new LinkedList<>();

    private static List<List<Integer>> combinationSum3(int k, int n) {
        PATH.clear();
        RESULT.clear();
        backtracking(k, n, 1);
        return RESULT;
    }

    private static void backtracking(int k, int n, int start) {
        // 编写终止条件
        if (n < 0)  {
            return;
        }

        if (k == PATH.size()) {
            if (n == 0) {
                RESULT.add(new ArrayList<>(PATH));
            }
            return;
        }

        // 编写for循环逻辑
        for (int i = start; (i <= 9) && (k - PATH.size() <= n - i + 1); i++) {
            // 处理结点
            PATH.add(i);
            // 递归
            backtracking(k, n - i, i + 1);
            // 回溯
            PATH.remove(PATH.size() - 1);
        }
    }
}
