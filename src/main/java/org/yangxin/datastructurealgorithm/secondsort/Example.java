package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 排序算法类的模板
 *
 * @author yangxin
 * 2020/06/15 16:50
 */
public class Example {

    public static <T> void sort(Comparable<T>[] a) {

    }

    @SuppressWarnings("all")
    static <T> boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T) w) < 0;
    }

    static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static <T> void show(Comparable<T>[] a) {
        // 在单行中打印数组
        for (Comparable<T> tComparable : a) {
            System.out.print(tComparable + " ");
        }
        System.out.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] a) {
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
        sort(a);
        show(a);
    }
}
