package org.yangxin.datastructurealgorithm.programmercarl.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangxin
 * 2022/3/13 11:44
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }

        return n == 1;
    }

    private static int getNextNumber(int n) {
        int result = 0;
        while (n > 0) {
            int num = n % 10;
            result += num * num;
            n /= 10;
        }

        return result;
    }
}
