package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yangxin
 * 2021/9/23 下午8:26
 */
public class SetMismatch {

    public static void main(String[] args) {
        // 期待[3,1]
//        int[] nums = {3, 2, 3, 4, 6, 5};
        // 期待[2,10]
//        int[] nums = {1, 5, 3, 2, 2, 7, 6, 4, 8, 9};
        int[] nums = {1, 1};
//        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    private static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        int[] output = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (i != 1 && output[0] == 0 && nums[i - 1] == nums[i - 2]) {
                output[0] = nums[i - 1];
            }

            if (i == nums[i - 1]) {
                continue;
            }


            if (!set.contains(i)) {
                output[1] = i;
            }
        }

        return output;
    }
}
