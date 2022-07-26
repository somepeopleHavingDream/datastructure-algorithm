package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/16 13:57
 */
public class UniquePathsIi {

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        int[][] obstacleGrid = {{0}, {1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int uniquePathsWithObstacles0(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        // dp[i]: 在该层到达位置为j处的唯一路径数
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];

        // dp[j] = 0 (obstacleGrid[i][j] == 1)
        // dp[j] += dp[j - 1] (obstacleGrid[i][j] == 0)
        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }

            dp[j] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j != 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[col - 1];
    }
}
