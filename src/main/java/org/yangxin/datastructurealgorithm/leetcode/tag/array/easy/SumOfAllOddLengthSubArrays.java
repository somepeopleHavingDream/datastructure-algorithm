package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/3/20 上午11:49
 */
@SuppressWarnings({"AlibabaUndefineMagicConstant", "CommentedOutCode"})
public class SumOfAllOddLengthSubArrays {

    public static int sumOddLengthSubArrays1(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int sum = 0;

        // 第一层循环限定子数组的长度
        for (int i = 1; i < arr.length + 1; i = i + 2) {
            // 第二层循环用于滑动子数组的起始位置
            for (int j = 0; j + i < arr.length + 1; j++) {
                // 第三层循环用于求和子数组
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
            }
        }

        return sum;
    }

    public static int sumOddLengthSubArrays2(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int[] prefixSumArr = new int[arr.length];
        prefixSumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
        }

        int sum = 0;
        for (int i = 1; i < arr.length + 1; i = i + 2) {
            for (int j = 0; j + i < arr.length + 1; j++) {
                if (j == 0) {
                    sum += prefixSumArr[i - 1];
                } else {
                    sum += prefixSumArr[j + i - 1] - prefixSumArr[j - 1];
                }
            }
        }

        return sum;
    }

    public static int sumOddLengthSubArrays3(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftOddNum = (i + 2) / 2;
            int leftEvenNum = (i + 1) / 2;
            int rightOddNum = (arr.length - i + 1) / 2;
            int rightEvenNum = (arr.length - i) / 2;

            sum += arr[i] * (leftEvenNum * rightEvenNum + leftOddNum * rightOddNum);
        }

        return sum;
    }

    public static void main(String[] args) {
//        testSumOfAllOddLengthSubArrays1();
//        testSumOddLengthSubArrays2();

        int[] arr1 = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubArrays3(arr1));

        int[] arr2 = {1, 2};
        System.out.println(sumOddLengthSubArrays3(arr2));

        int[] arr3 = {10, 11, 12};
        System.out.println(sumOddLengthSubArrays3(arr3));
    }

    private static void testSumOddLengthSubArrays2() {
        int[] arr1 = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubArrays2(arr1));

        int[] arr2 = {1, 2};
        System.out.println(sumOddLengthSubArrays2(arr2));

        int[] arr3 = {10, 11, 12};
        System.out.println(sumOddLengthSubArrays2(arr3));
    }

    private static void testSumOddLengthSubArrays1() {
        int[] arr1 = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubArrays1(arr1));

        int[] arr2 = {1, 2};
        System.out.println(sumOddLengthSubArrays1(arr2));

        int[] arr3 = {10, 11, 12};
        System.out.println(sumOddLengthSubArrays1(arr3));
    }
}
