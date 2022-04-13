package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/13 10:27
 */
public class MonotoneIncreasingDigits {

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
    }

    private static int monotoneIncreasingDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();

        // 从后往前遍历
        int length = charArray.length;
        int index = length;
        for (int i = length - 1; i > 0; i--) {
            int currentValue = charArray[i] - '0';
            int prevValue = charArray[i - 1] - '0';

            // 如果当前数字小于前一个数字
            if (currentValue < prevValue) {
                charArray[i - 1] = (char) (prevValue - 1 + '0');
                index = i;
            }
        }

        for (int i = index; i < length; i++) {
            charArray[i] = '9';
        }

        return Integer.parseInt(String.valueOf(charArray));
    }
}
