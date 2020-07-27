package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 旋转数组的最小数字
 *
 * @author yangxin
 * 2020/07/27 09:48
 */
public class MinArray {

    @SuppressWarnings("ConstantConditions")
    public static int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers.length == 0 ? null : numbers[0];
    }

    public static void main(String[] args) {
//        int[] numbers = {3, 4, 5, 1, 2};
        int[] numbers = {2, 2, 2, 0, 1};
        System.out.println(minArray(numbers));
    }
}
