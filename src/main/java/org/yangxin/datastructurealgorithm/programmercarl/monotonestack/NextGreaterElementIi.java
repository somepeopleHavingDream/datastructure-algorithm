package org.yangxin.datastructurealgorithm.programmercarl.monotonestack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangxin
 * 2022/4/26 15:47
 */
public class NextGreaterElementIi {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }

    private static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length * 2; i++) {
            Integer top = stack.peek();

            // 如果栈顶元素为null，或者当前元素值小于等于栈顶元素值
            if (top == null || nums[i % length] <= nums[top]) {
                stack.push(i % length);
                continue;
            }

            while (top != null && nums[i % length] > nums[top]) {
                result[top] = nums[i % length];
                stack.pop();
                top = stack.peek();
            }
            stack.push(i % length);
        }

        return result;
    }
}
