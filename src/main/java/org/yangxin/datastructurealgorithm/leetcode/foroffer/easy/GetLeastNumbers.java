package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 最小的k个数
 *
 * @author yangxin
 * 2020/09/02 10:45
 */
public class GetLeastNumbers {

    public static int[] getLeastNumbers(int[] arr, int k) {
        // 先升序
        Arrays.sort(arr);

        // 取前k个数
        int[] result = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, result, 0, k);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
//        int[] arr = {3, 2, 1};
        int k = 1;
//        int k = 2;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
}
