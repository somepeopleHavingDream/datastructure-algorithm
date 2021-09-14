package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxin
 * 2021/9/14 下午8:56
 */
public class RelativeRanks {

    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
//        int[] score = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    private static String[] findRelativeRanks(int[] score) {
        int[] sortedArray = Arrays.copyOf(score, score.length);
        Arrays.sort(sortedArray);

        Map<Integer, Integer> map = new HashMap<>(sortedArray.length);
        for (int i = 0; i < sortedArray.length; i++) {
            map.put(sortedArray[i], i);
        }

        String[] output = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            Integer rank = map.get(score[i]);
            if (rank == score.length - 1) {
                output[i] = "Gold Medal";
            } else if (rank == score.length - 2) {
                output[i] = "Silver Medal";
            } else if (rank == score.length - 3) {
                output[i] = "Bronze Medal";
            } else {
                output[i] = String.valueOf(score.length - rank);
            }
        }

        return output;
    }
}
