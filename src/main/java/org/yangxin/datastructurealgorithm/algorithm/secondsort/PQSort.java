package org.yangxin.datastructurealgorithm.algorithm.secondsort;

/**
 * 堆排序
 *
 * @author yangxin
 * 2020/06/20 14:48
 */
@SuppressWarnings("LoopConditionNotUpdatedInsideLoop")
public class PQSort<Key extends Comparable<Key>> {
//public class PQSort<Key extends Comparable<Key>> extends MaxPQ<Key> {

//    public PQSort(int maxN) {
//        super(maxN);
//    }

    public void sort(Key[] a) {
        int N = a.length;

        // for循环构造了堆
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        // while循环将最大的元素a[1]和a[N]交换并修复了堆
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void exch(Key[] a, int i, int j) {
        // 索引为i的元素实际存储在a[i-1]
        Key tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
    }

    /**
     * 将a[k]下沉
     * @param a 要操作的数组
     * @param k 要下沉的元素在数组中的索引
     * @param n 数组中元素的个数
     */
    private void sink(Key[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k ,j)) {
                break;
            }
            exch(a, k, j);
        }
    }

    private boolean less(Key[] a, int i, int j) {
        // 索引为i的元素实际存储在a[i-1]
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private void show(Key[] a) {
        // 在单行中打印数组
        for (Key t : a) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //        Integer[] a = new Integer[]{3, 2};
        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4};
        PQSort<Integer> pqSort = new PQSort<>();
        pqSort.sort(a);
        pqSort.show(a);
    }
}
