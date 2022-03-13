package org.yangxin.datastructurealgorithm.programmercarl.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxin
 * 2022/3/13 12:09
 */
@SuppressWarnings({"SameParameterValue", "AlibabaCollectionInitShouldAssignCapacity"})
public class TwoSum {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {3, 2, 4};
        int[] nums = {3, 3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                result[0] = i;
                result[1] = index;
                return result;
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
