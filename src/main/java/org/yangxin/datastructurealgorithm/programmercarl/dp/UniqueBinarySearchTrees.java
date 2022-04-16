package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/16 22:12
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(1));
    }

    private static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        return dp[n];
    }
}
