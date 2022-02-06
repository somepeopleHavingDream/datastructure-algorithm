package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.sample;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/2/6 17:27
 */
public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }
}
