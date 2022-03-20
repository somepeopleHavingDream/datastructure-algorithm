package org.yangxin.datastructurealgorithm.programmercarl.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangxin
 * 2022/3/20 20:53
 */
@SuppressWarnings("SameParameterValue")
public class FourSum {

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(fourSum(nums, 8));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 先排序
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length; j++)  {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

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
        }

        return result;
    }
}
