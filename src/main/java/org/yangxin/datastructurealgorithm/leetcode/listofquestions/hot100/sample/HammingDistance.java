package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.sample;

/**
 * @author yangxin
 * 2022/2/6 17:32
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(3, 1));
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
