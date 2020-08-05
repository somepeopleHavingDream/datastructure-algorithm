package org.yangxin.datastructurealgorithm.leetcode.foroffer.easy;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author yangxin
 * 2020/08/05 17:28
 */
public class Exchange {

    public static int[] exchange(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 找出奇数，如果是奇数放到前面位置
            if (nums[j] % 2 != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
//        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
