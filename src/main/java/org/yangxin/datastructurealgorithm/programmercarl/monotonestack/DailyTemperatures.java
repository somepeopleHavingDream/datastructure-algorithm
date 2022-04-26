package org.yangxin.datastructurealgorithm.programmercarl.monotonestack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangxin
 * 2022/4/25 17:46
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            // 获得栈顶元素值
            Integer top = stack.peek();

            // 如果栈为空，或者当前元素小于等于栈顶元素值
            if (top == null || temperatures[i] <= temperatures[top]) {
                stack.push(i);
                continue;
            }

            // 栈不为空，并且当前元素大于栈顶元素值
            while (top != null && temperatures[i] > temperatures[top]) {
                result[top] = i - top;

                stack.pop();
                top = stack.peek();
            }
            stack.push(i);
        }

        return result;
    }
}
