package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/2/20 13:42
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class DailyTemperatures {

    public static void main(String[] args) {
//        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] temperatures = {30, 40, 50, 60};
        int[] temperatures = {30, 60, 90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        result[length - 1] = 0;

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j += result[j]) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }

                if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }
}
