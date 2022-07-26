package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/15 17:59
 */
@SuppressWarnings("SameParameterValue")
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
    }

    private static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    private static int uniquePaths(int m, int n) {
        // dp[i]: 在该层到达位置i处的唯一路径数
        int[] dp = new int[n];

        // dp[i] += dp[i - 1]
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] +=  dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
