package org.yangxin.datastructurealgorithm.algorithm.secondsort;

/**
 * 插入排序
 *
 * @author yangxin
 * 2020/06/15 17:14
 */
public class Insertion<T extends Comparable<T>> extends Example<T> {

    @Override
    public void sort(T[] a) {
        // 将a[]按升序排列
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Character[] a = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Insertion<Character> insertion = new Insertion<>();
        insertion.sort(a);
        insertion.show(a);
    }
}
