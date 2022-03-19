package org.yangxin.datastructurealgorithm.programmercarl.string;

/**
 * @author yangxin
 * 2022/3/19 23:13
 */
@SuppressWarnings("DuplicatedCode")
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        // false
        System.out.println(repeatedSubstringPattern("abac"));
    }

    private static boolean repeatedSubstringPattern(String s) {
        // 先构造next数组
        int[] next = getNext(s);

        // 通过next数组判断是否存在重复子串
        int length = s.length();
        int maxPrefixSuffixLength = next[length - 1];
        return maxPrefixSuffixLength != 0 && length % (length - maxPrefixSuffixLength) == 0;
    }

    private static int[] getNext(String s) {
        int[] next = new int[s.length()];

        int j = 0;
        next[j] = 0;
        for (int i = 1; i < s.length(); i++) {
            // 前缀与后缀不想匹配
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                // 变更前缀位置
                j = next[j - 1];
            }

            // 前缀和后缀相匹配
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }
}
