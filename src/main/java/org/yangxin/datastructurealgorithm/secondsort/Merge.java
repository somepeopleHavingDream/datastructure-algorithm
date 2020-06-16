package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 原地归并的抽象方法
 * 自顶向下的归并排序
 *
 * @author yangxin
 * 2020/06/16 13:43
 */
public class Merge extends Example {

    /**
     * 归并所需的辅助数组
     */
    private static Comparable<?>[] aux;

    public static <T> void sort(Comparable<T>[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static <T> void sort(Comparable<T>[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(a, lo, mid);
        // 将右半边排序
        sort(a, mid + 1, hi);
        // 归并结果
        merge(a, lo, mid, hi);
    }

    static void merge(Comparable<?>[] a, int lo, int mid, int hi) {
        // 将a[lo..mid]和a[mid+1..hi]归并
        int i = lo, j = mid + 1;

        // 将a[lo..hi]复制到aux[lo..hi]
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        // 归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less((Comparable) aux[j], (Comparable) aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 2};
//        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4};
        sort(a);
        show(a);
    }
}