package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/25 15:31
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstringsByDp("abc"));
        System.out.println(countSubstringsByDp("aaa"));
        System.out.println(countSubstringsByDp("fdsklf"));
    }

    private static int countSubstringsByDp(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                // 单个字符必是回文串
                if (i == j) {
                    dp[i][j] = true;
                    result++;
                    continue;
                }

                // 如果起点字符与终点字符不相同
                boolean equals = s.charAt(i) == s.charAt(j);
                if (!equals) {
                    continue;
                }

                // 起点字符与终点字符相同，且距离小于等于2
                if (j - i <= 2) {
                    dp[i][j] = true;
                    result++;
                    continue;
                }

                // 终点字符位置与起点字符位置距离大于2
                if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }

        return result;
    }
}
