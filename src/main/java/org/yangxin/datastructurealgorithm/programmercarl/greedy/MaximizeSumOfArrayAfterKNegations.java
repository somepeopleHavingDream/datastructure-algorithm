package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/11 14:12
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "unused", "AlibabaLowerCamelCaseVariableNaming"})
public class MaximizeSumOfArrayAfterKNegations {

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
//        int[] nums = {3, -1, 0, 2};
//        int[] nums = {2, -3, -1, 5, -4};

        System.out.println(largestSumAfterKNegations(nums, 1));
    }

    private static int largestSumAfterKNegations(int[] nums, int k) {
        // 先按绝对值从大到小降序排序
        Integer[] numArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numArray, (o1, o2) -> Math.abs(o2) - Math.abs(o1));

        // 从前往后依次取反负数
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] < 0 && k > 0) {
                numArray[i] *= -1;
                k--;
            }
        }

        // 如果k有还有剩余，则只翻转绝对值最小的那个数
        if (k % 2 == 1) {
            numArray[numArray.length - 1] *= -1;
        }

        // 求和
        return Arrays.stream(numArray).mapToInt(Integer::intValue).sum();
    }
}
