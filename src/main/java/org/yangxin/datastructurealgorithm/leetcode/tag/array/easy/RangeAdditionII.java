package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/9/21 下午1:58
 */
public class RangeAdditionII {

    public static void main(String[] args) {
//        int m = 26, n = 17;
//        int m = 18, n = 3;
        int m = 3, n = 3;
//        int[][] ops = {{20, 10}, {26, 11}, {2, 11}, {4, 16}, {2, 3}, {23, 13}, {7, 15}, {11, 11}, {25, 13}, {11, 13}, {13, 11}, {13, 16}, {26, 17}};
        int[][] ops = {};
//        int[][] ops = {{16, 1}, {14, 3}, {14, 2}, {4, 1}, {10, 1}, {11, 1}, {8, 3}, {16, 2}, {13, 1}, {8, 3}, {2, 2}, {9, 1}, {3, 1}, {2, 2}, {6, 3}};
//        int[][] ops = {{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}};
//        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(maxCount(m, n, ops));
    }

    private static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }

        int minA = ops[0][0], minB = ops[0][1];
        for (int[] op : ops) {
            minA = Math.min(op[0], minA);
            minB = Math.min(op[1], minB);
        }

        return minA * minB;
    }
}
