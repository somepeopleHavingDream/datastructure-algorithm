package org.yangxin.datastructurealgorithm.programmercarl.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxin
 * 2022/3/21 21:11
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }

    private static String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character top = stack.peek();
            char c = s.charAt(i);
            if (top == null || top != c) {
                stack.push(c);
            } else {
                stack.poll();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.poll());
        }

        return result.toString();
    }
}
