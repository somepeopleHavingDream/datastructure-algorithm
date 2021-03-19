package org.yangxin.datastructurealgorithm.algorithm.firstbasic;

/**
 * 发明于2300多年前的欧几里得算法
 * 计算两个非负整数p和q的最大公约数：若q是0，则最大公约数为p。否则，将p处理q得到余数r，p和q的最大公约数即为q和r的最大公约数。
 *
 * @author yangxin
 * 2020/06/12 15:14
 */
public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd(1, 3));
        System.out.println(gcd(6, 4));
    }

    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;
        return gcd(q, r);
    }
}
