package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 自底向上的归并排序算法
 *
 * @author yangxin
 * 2020/06/16 14:42
 */
public class MergeBU<T extends Comparable<T>> extends Merge<T> {

    /**
     * 归并所需的辅助数组
     */
    private T[] aux;

    public void sort(T[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        aux = (T[]) new Comparable[N];

        // sz子数组大小
        for (int sz = 1; sz < N; sz = sz + sz) {
            // lo:子数组索引
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public void merge(T[] a, int lo, int mid, int hi) {
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
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
//        Integer[] a = new Integer[]{3, 2};
        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4};
        MergeBU<Integer> mergeBU = new MergeBU<>();
        mergeBU.sort(a);
        mergeBU.show(a);
    }
}
