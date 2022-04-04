package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/4 13:20
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));
    }

    private static final List<String> RESULT = new LinkedList<>();

    private static List<String> restoreIpAddresses(String s) {
        RESULT.clear();

        backtracking(new StringBuilder(s), 0, 0);
        return RESULT;
    }

    private static void backtracking(StringBuilder s, int start, int pointNum) {
        // 终止条件
        if (pointNum == 3) {
            if (isValid(s.toString(), start, s.length() - 1)) {
                RESULT.add(s.toString());
            }
            return;
        }

        // 单层for循环
        for (int i = start; i < s.length(); i++) {
            // 处理结点
            if (!isValid(s.toString(), start, i)) {
                break;
            }
            s.insert(i + 1, ".");

            // 递归
            backtracking(s, i + 2, pointNum + 1);
            // 回溯
            s.deleteCharAt(i + 1);
        }
    }

    private static boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        // 段位以0为开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            // 段位里有非整数字符不合法
            char c = s.charAt(i);
            if (c > '9' || c < '0') {
                return false;
            }

            // 段位如果大于255了不合法
            num = num * 10 + c - '0';
            if (num > 255) {
                return false;
            }
        }

        return true;
    }
}
