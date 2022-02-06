package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 青蛙跳台阶问题
 *
 * @author yangxin
 * 2020/07/27 09:39
 */
public class NumWays {

    @SuppressWarnings("DuplicatedCode")
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % 1000000007;
        }

        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(0));
        System.out.println(numWays(2));
        System.out.println(numWays(7));
    }
}
