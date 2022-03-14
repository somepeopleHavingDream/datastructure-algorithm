package org.yangxin.datastructurealgorithm.programmercarl.string;

/**
 * @author yangxin
 * 2022/3/14 22:23
 */
@SuppressWarnings("SameParameterValue")
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
        System.out.println("We%20are%20happy.");
    }

    private static String replaceSpace(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        char[] charArray = new char[s.length() + count * 2];
        for (int i = charArray.length - 1, j = s.length() - 1; j >= 0; i--, j--) {
            if (s.charAt(j) != ' ') {
                charArray[i] = s.charAt(j);
            } else {
                charArray[i--] = '0';
                charArray[i--] = '2';
                charArray[i] = '%';
            }
        }

        return new String(charArray);
    }
}
