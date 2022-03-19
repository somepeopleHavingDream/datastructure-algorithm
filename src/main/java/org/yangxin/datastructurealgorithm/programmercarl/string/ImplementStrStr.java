package org.yangxin.datastructurealgorithm.programmercarl.string;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/3/18 23:09
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
    }

    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        // 先构造next数组
        int[] next = getNext(needle);

        // 再用next数组做模式匹配
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 如果文本串与模式串当前对比的字符不相同
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            // 如果文本串与模式串当前对比的字符相同
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            // 如果模式串已遍历完
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }

    private static int[] getNext(String needle) {
        int length = needle.length();
        int[] next = new int[length];

        int j = 0;
        next[j] = 0;
        for (int i = 1; i < length; i++) {
            // 前缀跟后缀不匹配
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            // 前缀和后缀匹配
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }
}
