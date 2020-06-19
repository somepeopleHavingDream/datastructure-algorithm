package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 原地归并的抽象方法
 * 自顶向下的归并排序
 *
 * @author yangxin
 * 2020/06/16 13:43
 */
public class Merge<T extends Comparable<T>> extends Example<T> {

    /**
     * 归并所需的辅助数组
     */
    private T[] aux;

    public void sort(T[] a) {
        // 一次性分配空间
        aux = (T[]) new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int lo, int hi) {
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

    private void merge(T[] a, int lo, int mid, int hi) {
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
        Merge<Integer> merge = new Merge<>();
        merge.sort(a);
        merge.show(a);
    }
}