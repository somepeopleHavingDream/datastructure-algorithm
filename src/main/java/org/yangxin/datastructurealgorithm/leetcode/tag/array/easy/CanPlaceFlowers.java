package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/3/21 下午5:05
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 1) {
                i = i + 2;
                continue;
            }

            if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                i = i + 3;
                continue;
            }

            n--;
            i = i + 2;
            if (n <= 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println(canPlaceFlowers(flowerbed1, n1));

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println(canPlaceFlowers(flowerbed2, n2));

        int[] flowerbed3 = {1, 0, 0, 0, 0, 1};
        int n3 = 2;
        System.out.println(canPlaceFlowers(flowerbed3, n3));

        int[] flowerbed4 = {1, 0, 1, 0, 1, 0, 1};
        int n4 = 0;
        System.out.println(canPlaceFlowers(flowerbed4, n4));
    }
}
