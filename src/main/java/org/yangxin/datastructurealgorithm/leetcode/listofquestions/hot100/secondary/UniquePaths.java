package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/20 15:45
 */
public class UniquePaths {

    public static void main(String[] args) {
//        int m = 3, n = 7;
        int m = 3, n = 2;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
