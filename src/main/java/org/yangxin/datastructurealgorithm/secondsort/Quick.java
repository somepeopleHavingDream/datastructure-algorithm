package org.yangxin.datastructurealgorithm.secondsort;

/**
 * 快速排序
 *
 * @author yangxin
 * 2020/06/16 15:16
 */
public class Quick extends Example{

    public static <T> void sort(Comparable<T>[] a) {
        // 消除对输入的依赖
        //        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable<?>[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        // 切分（请见“快速排序的切分"）
        int j = partition(a, lo, hi);
        // 将左半部分a[lo..j-1]排序
        sort(a, lo, j - 1);
        // 将右半部分a[j+1..hi]排序
        sort(a, j + 1, hi);
    }

    /**
     * 快速排序的切分
     */
    private static <T> int partition(Comparable<T>[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1]，a[i]，a[i+1..hi]
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        Comparable<T> v = a[lo];
        while (true) {
            // 左右扫描，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }
        // 将v=a[j]放入正确的位置
        exch(a, lo, j);
        // a[lo..j-1] <= a[j] <= a[j+1..hi]达成
        return j;
    }
}
