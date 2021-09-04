package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yangxin
 * 2021/9/4 下午2:26
 */
public class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        int[] nums = {1, 1};
//        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        List<Integer> result = new ArrayList<>(set.size());
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
