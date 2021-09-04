package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yangxin
 * 2021/9/4 上午11:53
 */
@SuppressWarnings("CommentedOutCode")
public class ThirdMaximumNumber {

    private static int thirdMax(int[] nums) {
        int[] array = IntStream.of(nums).distinct().sorted().toArray();

        int length = array.length;
        return length >= 3 ? array[length - 3] : array[length - 1];
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 3, 1};
//        int[] nums = {1, 2};
        int[] nums = {3, 2, 1};
        System.out.println(thirdMax(nums));
    }
}
