package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/21 21:35
 */
@SuppressWarnings("AlibabaAvoidComplexCondition")
public class PalindromicSubstrings {

    public static void main(String[] args) {
//        String s = "abc";
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    private static int countSubstrings(String s) {
        int result = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        // dp[i][j]是由dp[i+1][j-1]推导而来
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    result++;
                    dp[i][j] = true;
                }
            }
        }

        return result;
    }
}
