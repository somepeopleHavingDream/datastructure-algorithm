package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.*;

/**
 * @author yangxin
 * 2022/4/28 17:38
 */
public class DecodeString {

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("100[leetcode]"));
    }

    private static String decodeString(String s) {
        int i = 0;
        char[] array = s.toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<StringBuilder> builderStack = new ArrayDeque<>();

        while (i < array.length) {
            char c = array[i];

            if (Character.isDigit(c)) {
                int prev = i;
                while (i < array.length && array[i] <= '9' && array[i] >= '0') {
                    i++;
                }

                stack.push(Integer.parseInt(s.substring(prev, i)));
                builderStack.push(new StringBuilder());
            } else if (c >= 'a' && c <= 'z') {
                builderStack.peek().append(c);
            } else if (c == ']') {
                Integer popNum = stack.pop();
                StringBuilder popBuilder = builderStack.pop();

                builderStack.peek().append(popBuilder.toString().repeat(popNum));
            }

            i++;
        }

        return builderStack.peek().toString();
    }
}
