package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/24 17:16
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        int result = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
