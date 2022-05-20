package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/19 10:11
 */
@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class OnesAndZeroes {

    public static void main(String[] args) {
//        String[] strs = {"10", "0001", "111001", "1", "0"};
        String[] strs = {"10", "0", "1"};
        System.out.println(findMaxForm(strs, 1, 1));
    }

    private static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)
        for (String s : strs) {
            int zeroNum = 0, oneNum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
