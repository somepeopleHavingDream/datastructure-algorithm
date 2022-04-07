package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 12:38
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
    }

    private static final List<String> PATH = new LinkedList<>();
    private static final List<List<String>> RESULT = new LinkedList<>();

    private static List<List<String>> partition(String s) {
        PATH.clear();
        RESULT.clear();

        backtracking(s, 0);
        return RESULT;
    }

    private static void backtracking(String s, int start) {
        // 终止条件
        if (start >= s.length()) {
            RESULT.add(new ArrayList<>(PATH));
            return;
        }

        // 单层循环逻辑
        for (int i = start; i < s.length(); i++) {
            // 处理结点
            if (isPalindrome(s, start, i)) {
                PATH.add(s.substring(start, i + 1));
            } else {
                continue;
            }

            // 递归
            backtracking(s, i + 1);
            // 回溯
            PATH.remove(PATH.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
