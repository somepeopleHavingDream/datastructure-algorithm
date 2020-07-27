package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

/**
 * 斐波那契数列
 *
 * @author yangxin
 * 2020/07/27 09:04
 */
public class Fib {

    /**
     * f(0)=0
     * f(1)=1
     * f(2)=f(1)+f(0)=1+0=1
     * f(3)=f(2)+f(1)=1+1=2
     * f(4)=f(3)+f(2)=2+1=3
     * f(5)=f(4)+f(3)=3+2=5
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibs[i] = (fibs[i - 1] + fibs[i - 2]) % 1000000007;
        }

        return fibs[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(44));
        // 134903163
        System.out.println(fib(45));
        // 807526948
        System.out.println(fib(48));
    }
}
