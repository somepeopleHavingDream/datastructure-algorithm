package org.yangxin.datastructurealgorithm.algorithm.firstbasic;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author yangxin
 * 2020/06/12 15:41
 */
public class BinarySearch {

    public static void main(String[] args) {
        int key = 8;
        int[] a = {8, 1, 9, 11, 12, 0, 549};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(rank(key, a));
    }

    private static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
