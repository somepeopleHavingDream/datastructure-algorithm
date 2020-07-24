package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现队列
 *
 * @author yangxin
 * 2020/07/24 10:22
 */
public class CQueue {

    /**
     * 用以入元素
     */
    private final Deque<Integer> stack1;

    /**
     * 用以出元素
     */
    private final Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack1.push(value);
    }

    public int deleteHead() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(4);
        cQueue.appendTail(3);
        cQueue.appendTail(2);
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
    }
}
