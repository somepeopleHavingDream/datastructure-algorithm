package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/3/22 下午8:17
 */
public class RichestCustomerWealth {

    public static int maximumWealth(int[][] accounts) {
        if (accounts == null) {
            return 0;
        }

        int maximumWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }

            if (sum > maximumWealth) {
                maximumWealth = sum;
            }
        }

        return maximumWealth;
    }

    public static void main(String[] args) {
        int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(maximumWealth(accounts1));

        int[][] accounts2 = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println(maximumWealth(accounts2));

        int[][] accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(maximumWealth(accounts3));
    }
}
