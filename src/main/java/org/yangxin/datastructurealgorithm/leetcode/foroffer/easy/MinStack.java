package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 包含min函数的栈
 *
 * @author yangxin
 * 2020/08/21 17:50
 */
public class MinStack {

    private final Deque<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek() == null ? 0 : stack.peek();
    }

    public int min() {
        Iterator<Integer> iterator = stack.iterator();
        int min = top();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next < min) {
                min = next;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回-3
        System.out.println(minStack.min());
        minStack.pop();
        // 返回0
        System.out.println(minStack.top());
        // 返回-2
        System.out.println(minStack.min());
    }
}
