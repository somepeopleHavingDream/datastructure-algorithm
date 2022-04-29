package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Deque;

/**
 * @author yangxin
 * 2022/4/28 17:38
 */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    private static String decodeString(String s) {
        return null;
    }

    private static void buildStack(int start, String s, Deque<Character> stack) {
        // 编写终止条件
        if (stack.isEmpty()) {
            return;
        }

        // 编写单层逻辑

    }
}
