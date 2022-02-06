package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

/**
 * 二维数组中的查找
 *
 * @author yangxin
 * 2020/07/24 10:01
 */
public class FindNumberIn2dArray {

    public static boolean findNumberIn2dArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (target == anInt) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2dArray(matrix, 5));
        System.out.println(findNumberIn2dArray(matrix, 20));
    }
}
