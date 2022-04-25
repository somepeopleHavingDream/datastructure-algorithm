package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/25 16:41
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubsequence("bbbab"));
        System.out.println(longestPalindromeSubsequence("cbbd"));
    }

    private static int longestPalindromeSubsequence(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
