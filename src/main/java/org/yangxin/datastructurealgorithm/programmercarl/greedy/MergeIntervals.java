package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/12 11:54
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {4, 5}};
//        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals) {
        // 按左边界升序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            // 如果当前区间与相邻左区间重叠
            if (end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
            } else {
                result.add(new int[] {start, end});

                start = intervals[i + 1][0];
                end = intervals[i + 1][1];
            }
        }
        result.add(new int[] {start, end});

        return result.toArray(new int[0][]);
    }
}
