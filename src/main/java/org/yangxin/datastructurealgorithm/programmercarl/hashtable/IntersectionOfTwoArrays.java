package org.yangxin.datastructurealgorithm.programmercarl.hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangxin
 * 2022/3/10 21:52
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);

        return set1.stream().mapToInt(Integer::intValue).toArray();
    }
}
