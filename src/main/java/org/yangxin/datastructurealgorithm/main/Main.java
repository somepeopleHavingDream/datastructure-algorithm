package org.yangxin.datastructurealgorithm.main;

/**
 * @author yangxin
 * 2022/5/19 19:35
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(compute(3, 4, 1, 2));
        System.out.println(compute1(3, 4, 1, 2));

        System.out.println(compute(1, 1, 5, 6));
        System.out.println(compute1(1, 1, 5, 6));
    }

    public static int compute1(int n, int m, int a, int b) {
        int result = 0;

        while (n >= 2 || m >= 2) {
            if (a >= b) {
                result += a;
                n -= 2;
                m -= 1;
            } else {
                result += b;
                n -= 1;
                m -= 2;
            }
        }

        return result;
    }

    private static int compute(int n, int m, int a, int b) {
        // dp[i][j]：i个苹果，j个桃子可以组成的最大价值数
        int[][] dp = new int[n + 1][m + 1];

        /*
            dp[i][j] = Math.max(dp[i - 2][j - 1] + a, dp[i - 1][j - 2] + b)
         */
        for (int j = 2; j <= m; j++) {
            dp[1][j] = b;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = a;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 2][j - 1] + a, dp[i - 1][j - 2] + b);
            }
        }

        return dp[n][m];
    }
}
