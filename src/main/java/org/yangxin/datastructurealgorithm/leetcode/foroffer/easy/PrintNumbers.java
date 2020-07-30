package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 *
 * @author yangxin
 * 2020/07/30 16:37
 */
public class PrintNumbers {

    public static int[] printNumbers(int n) {
        int[] result = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] numbers = printNumbers(2);
//        int[] numbers = printNumbers(1);
        int[] numbers = printNumbers(3);
        System.out.println(Arrays.toString(numbers));
    }
}
