package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/16 14:10
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(10));
    }

    private static int integerBreak(int n) {
        // dp[i]: 拆分i的所有整数的最大乘积
        /*
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]))
            }
        */
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
