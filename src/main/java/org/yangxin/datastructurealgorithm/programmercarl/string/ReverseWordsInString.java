package org.yangxin.datastructurealgorithm.programmercarl.string;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/3/16 21:49
 */
@SuppressWarnings({"AlibabaUndefineMagicConstant", "StatementWithEmptyBody", "UnnecessaryContinue"})
public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

    private static String reverseWords(String s) {
        /*
            1 移除多余空格
            2 反转字符串
            3 反转单词
         */

        // 移除多余空格
        char[] charArray = cleanExtraSpace(s);
        // 反转字符串
        reverseCharArray(charArray, 0, charArray.length - 1);
        // 反转单词
        reverseWord(charArray);

        return new String(charArray);
    }

    private static void reverseWord(char[] charArray) {
        int start = 0, end = 0;
        for (; end <= charArray.length; end++) {
            if (end == charArray.length || charArray[end] == ' ') {
                reverseCharArray(charArray, start, end - 1);
                start = end + 1;
            }
        }
    }

    private static void reverseCharArray(char[] charArray, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
        }
    }

    private static char[] cleanExtraSpace(String s) {
        char[] charArray = s.toCharArray();
        int slowIndex = 0, fastIndex = 0;
        for (; fastIndex < charArray.length && charArray[fastIndex] == ' '; fastIndex++) {
        }

        // 去除字符串中间的空格
        for (; fastIndex < s.length() ; fastIndex++) {
            if (fastIndex > 0 && charArray[fastIndex] == ' ' && charArray[fastIndex] == charArray[fastIndex - 1]) {
                continue;
            } else {
                charArray[slowIndex++] = charArray[fastIndex];
            }
        }

        if (charArray[slowIndex - 1] == ' ') {
            --slowIndex;
        }
        return Arrays.copyOf(charArray, slowIndex);
    }
}
