package org.yangxin.datastructurealgorithm.programmercarl.stackqueue;

import java.util.Stack;

/**
 * @author yangxin
 * 2022/3/21 19:48
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    private static class MyQueue {

        private final Stack<Integer> in;
        private final Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            return popOrPeek(true);
        }

        public int peek() {
            return popOrPeek(false);
        }

        private int popOrPeek(boolean pop) {
            if (!out.empty()) {
                return pop ? out.pop() : out.peek();
            }

            while (!in.empty()) {
                out.push(in.pop());
            }

            return pop ? out.pop() : out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }
}
