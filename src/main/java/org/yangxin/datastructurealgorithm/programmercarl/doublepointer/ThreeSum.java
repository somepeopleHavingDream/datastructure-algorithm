package org.yangxin.datastructurealgorithm.programmercarl.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/20 0:24
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {};
//        int[] nums = {0};
//        int[] nums = {0, 0};

        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 先升序
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 如果排序后的首元素为正数，则直接返回
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 定义左指针、右指针
            int left = i + 1, right = length - 1;
            while (left < right) {
                // 如果nums[i]+nums[left]+nums[right]=0
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // 如果nums[i]+nums[left]+nums[right] < 0，则移动右指针
                    right--;
                } else if (sum < 0) {
                    // 如果nums[i]+nums[left]+nums[right] < 0，则移动左指针
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 更新左右指针
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
