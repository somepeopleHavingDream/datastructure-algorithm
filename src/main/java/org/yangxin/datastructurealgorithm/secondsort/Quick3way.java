package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 三向切分的快速排序
 *
 * @author yangxin
 * 2020/06/18 14:50
 */
public class Quick3way<T extends Comparable<T>> extends Example<T> {

    public void sort(T[] a) {
        // 消除对输入的依赖
        //        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo, i = lo + 1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        // 现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] args) {
//        Integer[] a = new Integer[]{3, 2};
        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4, 3};
        // 3, 3, 9, 2, 0, 19, 4, 7  i = 1, gt = 6, lt = 0;
        // 3, 3, 9, 2, 0, 19, 4, 7  i = 2, gt = 6, lt = 0;
        // 3, 3, 4, 2, 0, 19, 9, 7  i = 2, gt = 5, lt = 0;
        // 3, 3, 19, 2, 0, 4, 9, 7  i = 2, gt = 4, lt = 0;
        // 3, 3, 0, 2, 19, 4, 9, 7  i = 2, gt = 3, lt = 0;
        // 0, 3, 3, 2, 19, 4, 9, 7  i = 3, gt = 3, lt = 1;
        // 0, 2, 3, 3, 19, 4, 9, 7  i = 4, gt = 3, lt = 2;
        Quick3way<Integer> quick3way = new Quick3way<>();
        quick3way.sort(a);
        quick3way.show(a);
    }
}
