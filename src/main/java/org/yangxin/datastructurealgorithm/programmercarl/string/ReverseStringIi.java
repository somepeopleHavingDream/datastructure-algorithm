package org.yangxin.datastructurealgorithm.programmercarl.string;

/**
 * @author yangxin
 * 2022/3/13 20:55
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class ReverseStringIi {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcd", 2));
        System.out.println(reverseStr("abcdef", 3));
    }

    private static String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, charArray.length - 1);

            while (start < end) {
                char tmp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = tmp;

                start++;
                end--;
            }
        }

        return new String(charArray);
    }
}
