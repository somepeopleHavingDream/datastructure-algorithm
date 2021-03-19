package org.yangxin.datastructurealgorithm.algorithm.secondsort;

/**
 * 快速排序
 *
 * @author yangxin
 * 2020/06/16 15:16
 */
@SuppressWarnings("AlibabaRemoveCommentedCode")
public class Quick<T extends Comparable<T>> extends Example<T> {

    @Override
    public void sort(T[] a) {
        // 消除对输入的依赖
        //        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public void sort(T[] a, int lo, int hi) {
        // 如果是单个元素，则它已经有序了，直接退出
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
    public int partition(T[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1]，a[i]，a[i+1..hi]
        // 左右扫描指针
        int i = lo, j = hi + 1;
        // 切分元素
        T v = a[lo];
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
        show(a);
        // a[lo..j-1] <= a[j] <= a[j+1..hi]达成
        return j;
    }

    public static void main(String[] args) {
//        Character[] a = new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
//        sort(a);
//        show(a);

//        Integer[] a = new Integer[]{3, 2};
        Integer[] a = new Integer[]{3, 7, 9, 2, 0, 19, 4};
        // 3, 0, 9, 2, 7, 19, 4
        // 3, 0, 2, 9, 7, 19, 4
        // 2, 0, 3, 9, 7, 19, 4
        Quick<Integer> quick = new Quick<>();
        quick.sort(a);
        quick.show(a);
    }
}
