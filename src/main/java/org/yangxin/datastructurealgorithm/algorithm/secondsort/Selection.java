package org.yangxin.datastructurealgorithm.algorithm.secondsort;

/**
 * 选择排序
 *
 * @author yangxin
 * 2020/06/15 17:06
 */
public class Selection<T extends Comparable<T>> extends Example<T> {

    @Override
    public void sort(T[] a) {
        // 将a[]按升序排列
        // 数组长度
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1..N]中最小的元素交换
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Character[] a = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Selection<Character> selection = new Selection<>();
        selection.sort(a);
        selection.show(a);
    }
}
