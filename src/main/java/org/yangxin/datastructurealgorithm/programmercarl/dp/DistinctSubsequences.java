package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/25 10:47
 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }

    private static int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i < length1; i++) {
            dp[i][0] = 1;
        }
        dp[0][0] = 1;

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length1][length2];
    }
}
