package org.yangxin.datastructurealgorithm.programmercarl.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

/**
 * @author yangxin
 * 2022/3/21 22:11
 */
@SuppressWarnings("SameParameterValue")
public class SlidingWindowMaximum {

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 1)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int[] result = new int[length - k + 1];
        DecreasingQueue queue = new DecreasingQueue();

        // 先入队k个元素
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        result[count++] = queue.front();

        // 再遍历剩下的元素
        for (int i = k; i < length; i++) {
            queue.poll(nums[i - k]);
            queue.offer(nums[i]);
            result[count++] = queue.front();
        }

        return result;
    }

    private static class DecreasingQueue {

        private final Deque<Integer> deque;

        public DecreasingQueue() {
            deque = new ArrayDeque<>();
        }

        public void poll(Integer value) {
            // 只有当窗口移出元素值与队头元素相等时，才弹出队头
            if (!deque.isEmpty() && Objects.equals(deque.peek(), value)) {
                deque.poll();
            }
        }

        public void offer(Integer value) {
            // 当入队元素的值大于队尾元素值，则一直弹出队尾
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offer(value);
        }

        public Integer front() {
            return deque.peek();
        }
    }
}
