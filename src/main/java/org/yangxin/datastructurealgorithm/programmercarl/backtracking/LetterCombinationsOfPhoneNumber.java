package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 0:18
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    private static final StringBuilder PATH = new StringBuilder();
    private static final List<String> RESULT = new LinkedList<>();

    private static final String[] MAP = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private static List<String> letterCombinations(String digits) {
        PATH.delete(0, PATH.length());
        RESULT.clear();

        backtracking(digits, 0);
        return RESULT;
    }

    private static void backtracking(String digits, int index) {
        // 终止条件
        if (digits.length() == 0) {
            return;
        }

        if (PATH.length() == digits.length()) {
            RESULT.add(PATH.toString());
            return;
        }

        // 单层循环逻辑
        String s = MAP[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            // 处理结点
            PATH.append(s.charAt(i));
            // 递归
            backtracking(digits, index + 1);
            // 回溯
            PATH.deleteCharAt(PATH.length() - 1);
        }
    }
}
