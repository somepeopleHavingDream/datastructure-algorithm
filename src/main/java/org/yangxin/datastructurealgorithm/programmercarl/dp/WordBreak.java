package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangxin
 * 2022/4/20 10:59
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        // dp[j]: 字符串s中，长度为j的子串，是否能被字典中的单词所填满
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                String substr = s.substring(i, j);
                if (wordDict.contains(substr) && dp[i]) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
