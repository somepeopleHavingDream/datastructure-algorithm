package org.yangxin.datastructurealgorithm.programmercarl.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxin
 * 2022/3/13 12:38
 */
@SuppressWarnings("AlibabaCollectionInitShouldAssignCapacity")
public class SumIi {

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
//        int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};
//        int[] nums1 = {-1, -1}, nums2 = {-1, 1}, nums3 = {-1, 1}, nums4 = {1, -1};

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int key = i + j;
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
        }

        int result = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int key = -(i + j);
                if (map.containsKey(key)) {
                    result += map.get(key);
                }
            }
        }

        return result;
    }
}
