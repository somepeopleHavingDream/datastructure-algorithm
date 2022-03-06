package org.yangxin.datastructurealgorithm.programmercarl.array;

/**
 * @author yangxin
 * 2022/3/6 19:48
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        String result = "";
        Integer maxLength = Integer.MIN_VALUE;

        int i = 0, j = 0, length = 1;
        for (; j < s.length(); j++) {

        }

        return "";
    }
}
