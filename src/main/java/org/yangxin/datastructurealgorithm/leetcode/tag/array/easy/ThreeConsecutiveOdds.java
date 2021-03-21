package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/3/21 下午3:28
 */
public class ThreeConsecutiveOdds {

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                count++;

                if (count >= 3) {
                    break;
                }
            } else {
                count = 0;
            }
        }

        return count >= 3;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 1};
        System.out.println(threeConsecutiveOdds(arr1));

        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(threeConsecutiveOdds(arr2));

        int[] arr3 = {1, 2, 1, 1};
        System.out.println(threeConsecutiveOdds(arr3));
    }
}
