package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 二进制中1的个数
 *
 * @author yangxin
 * 2020/07/30 16:31
 */
public class HammingWeight {

    /**
     * you need to treat n as an unsigned value
     */
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }
}
