package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/2/9 21:58
 */
@SuppressWarnings("CommentedOutCode")
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = " ";
//        String s = "";

        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int[] position = new int[256];
        Arrays.fill(position, -1);

        int start = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            // 计算出窗口开始的位置（当当前字符是曾经遍历过的字符时，滑动窗口）
            char index = s.charAt(i);

            start = Math.max(start, position[index] + 1);
            // 最大的窗口长度，即为最长子串的长度
            longest = Math.max(longest, i - start + 1);

            // 存储当前值的下标
            position[index] = i;
        }

        return longest;
    }
}
