package org.yangxin.datastructurealgorithm.algorithm.secondsort.mysort;

import java.util.Arrays;

/**
 * @author yangxin
 * 2020/12/13 15:44
 */
public class MySort {

    public static void main(String[] args) {
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};

        // 插入排序
//        insertSort(array);

        // 归并排序
        mergeSort(array);

        // 打印排序结果
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序
     */
    private static void mergeSort(int[] array) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] aux = new int[array.length];
        mergeSort(array, 0, array.length - 1, aux);
    }

    /**
     * 归并排序（闭区间）
     */
    private static void mergeSort(int[] array, int left, int right, int[] aux) {
        if (left < right) {
            // 取中位下标
            int mid = left + (right - left) / 2;

            // 左边归并排序，使得左子序列有序（处于“分”的阶段）
            mergeSort(array, left, mid, aux);
            // 右边归并排序，使得右子序列有序（处于“分”的阶段）
            mergeSort(array, mid + 1, right, aux);

            // 将两个有序子数组合并操作（处于“治”的阶段）
            merge(array, left, mid, right, aux);
        }
    }

    /**
     * “分治”阶段的“治”
     */
    private static void merge(int[] array, int left, int mid, int right, int[] aux) {
        // 左序列指针
        int i = left;
        // 右序列指针
        int j = mid + 1;
        // 辅助数组指针
        int t = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                aux[t++] = array[i++];
            } else {
                aux[t++] = array[j++];
            }
        }

        // 将左边剩余元素填充进辅助数组中
        while (i <= mid) {
            aux[t++] = array[i++];
        }

        // 将右边剩余元素填充进辅助数组中
        while (j <= right) {
            aux[t++] = array[j++];
        }

        // 将辅助数组中的元素全部拷贝到原数组中
        t = 0;
        while (left <= right) {
            array[left++] = aux[t++];
        }
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
    }
}
