package org.yangxin.datastructurealgorithm.programmercarl.string;

/**
 * @author yangxin
 * 2022/3/13 20:40
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
//        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(s);
    }

    private static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
