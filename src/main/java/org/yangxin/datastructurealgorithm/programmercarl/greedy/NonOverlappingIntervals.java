package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangxin
 * 2022/4/12 10:10
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        int[][] intervals = {{1, 2}, {2, 3}};

        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[1])));

        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
