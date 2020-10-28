package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 排序算法类的模板
 *
 * @author yangxin
 * 2020/06/15 16:50
 */
public class Example<T extends Comparable<T>> {

    public void sort(T[] a) {

    }

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    void show(T[] a) {
        // 在单行中打印数组
        for (T t : a) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private boolean isSorted(T[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4};
        Example<Integer> example = new Example<>();
        example.sort(a);
        example.show(a);
    }
}
