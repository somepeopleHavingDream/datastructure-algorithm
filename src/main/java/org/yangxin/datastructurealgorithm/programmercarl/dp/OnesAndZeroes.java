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
        dp[0][0] = 0;

        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int a = m; a >= zeroNum; a--) {
                for (int b = n; b >= oneNum; b--) {
                    dp[a][b] = Math.max(dp[a][b], dp[a - zeroNum][b - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
