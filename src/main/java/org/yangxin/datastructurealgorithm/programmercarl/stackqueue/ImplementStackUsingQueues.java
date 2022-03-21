package org.yangxin.datastructurealgorithm.programmercarl.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/3/21 20:29
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    @SuppressWarnings("ConstantConditions")
    private static class MyStack {

        private final Queue<Integer> queue;

        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            return popOrPeek(true);
        }

        public int top() {
            return popOrPeek(false);
        }

        private Integer popOrPeek(boolean isPop) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }

            int result;
            if (isPop) {
                result = queue.poll();
            } else {
                result = queue.peek();
                queue.offer(queue.poll());
            }

            return result;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
