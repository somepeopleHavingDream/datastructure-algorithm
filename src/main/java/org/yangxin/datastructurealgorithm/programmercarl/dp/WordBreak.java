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
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j, i);
                if (set.contains(str) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
