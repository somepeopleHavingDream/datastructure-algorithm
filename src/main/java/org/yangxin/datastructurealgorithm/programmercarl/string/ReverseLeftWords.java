package org.yangxin.datastructurealgorithm.programmercarl.string;

/**
 * @author yangxin
 * 2022/3/18 22:40
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }

    private static String reverseLeftWords(String s, int n) {
        char[] charArray = s.toCharArray();
        reverseCharArray(charArray, 0, n - 1);
        reverseCharArray(charArray, n, charArray.length - 1);
        reverseCharArray(charArray, 0, charArray.length - 1);

        return new String(charArray);
    }

    private static void reverseCharArray(char[] charArray, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
        }
    }
}
