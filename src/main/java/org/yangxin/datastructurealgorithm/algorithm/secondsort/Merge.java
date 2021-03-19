package org.yangxin.datastructurealgorithm.algorithm.secondsort;

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

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] a) {
        // 一次性分配空间
        aux = (T[]) new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    @SuppressWarnings("DuplicatedCode")
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

    @SuppressWarnings("DuplicatedCode")
    private void merge(T[] a, int lo, int mid, int hi) {
        // 将a[lo..mid]和a[mid+1..hi]归并，此时a[lo..mid]和a[mid+1..hi]都已有序
        // i代表左边排序列表的起点，j代表右边排序列表的起点
        int i = lo, j = mid + 1;

        // 将a[lo..hi]复制到aux[lo..hi]
        if (hi + 1 - lo >= 0) {
            System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        }

        // 归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // 右半部分的合并
                a[k] = aux[j++];
            } else if (j > hi) {
                // 如果进入到这个判断，说明当前合并是左半部分的合并
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                // 如果进入到这个判断，说明当前合并是右半部分的合并
                a[k] = aux[j++];
            } else {
                // 左半部分的合并
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