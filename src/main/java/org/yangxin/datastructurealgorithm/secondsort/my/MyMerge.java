package org.yangxin.datastructurealgorithm.secondsort.my;

import org.yangxin.datastructurealgorithm.secondsort.Example;

/**
 * @author yangxin
 * 2020/10/28 16:57
 */
public class MyMerge<T extends Comparable<T>> extends Example<T> {

    @Override
    public void sort(T[] a) {
        // 如果数组长度为0或1，则认为有序，不排序。
        if (a.length == 0 || a.length == 1) {
            return;
        }

        sort(a, 0, a.length - 1);
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] a, int low, int mid, int high) {
        // 构造并初始化辅助数组
        T[] aux = (T[]) new Comparable[a.length];
        if (high + 1 - low > 0) {
            System.arraycopy(a, low, aux, 0, high + 1 - low);
        }

        // 比较排序
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (less(aux[i], aux[j])) {
                i++;
            } else {
                a[i] = aux[j++];
            }
        }
    }

    /**
     * 升序
     */
    @SuppressWarnings("DuplicatedCode")
    private void sort(T[] a, int low, int high) {
        // 我们认定一个元素为有序，这种情况直接返回
       if (low >= high) {
           return;
       }

       // 获得中间分割点
       int mid = low + (high - low) / 2;

       // 对左半部分进行排序
       sort(a, low, high);
       // 对右半部分进行排序
       sort(a, mid + 1, high);

       // 将左右两边有序部分归并
       merge(a, low, mid, high);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4};
        MyMerge<Integer> myMerge = new MyMerge<>();
        myMerge.sort(a);
    }
}
