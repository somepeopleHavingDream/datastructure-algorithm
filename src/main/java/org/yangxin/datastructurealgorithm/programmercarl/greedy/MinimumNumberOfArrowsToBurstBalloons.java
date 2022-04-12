package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangxin
 * 2022/4/12 9:16
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int result = 1;
        for (int i = 0; i < points.length - 1; i++) {
            // 相邻气球不挨在一起的情况
            if (points[i][1] < points[i + 1][0]) {
                result++;
            } else {
                // 相邻气球挨在一起的情况
                points[i + 1][1] = Math.min(points[i + 1][1], points[i][1]);
            }
        }

        return result;
    }
}
