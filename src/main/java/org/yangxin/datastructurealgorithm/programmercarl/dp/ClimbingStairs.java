package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/14 21:36
 */
@SuppressWarnings({"AlibabaUndefineMagicConstant", "AlibabaRemoveCommentedCode", "SameParameterValue"})
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));

        System.out.println(climbStairs(2, 2));
        System.out.println(climbStairs(3, 2));
    }

    private static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int climbStairs(int n, int m) {
        // dp[i]: 爬上第i阶楼梯，有多少种不同的方法
        int[] dp = new int[n + 1];

        // dp[j] += dp[j - i]
        dp[0] = 1;
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i <= 2; i++) {
                if (j < i) {
                    continue;
                }

                dp[j] += dp[j - i];
            }
        }

        return dp[n];
    }
}
