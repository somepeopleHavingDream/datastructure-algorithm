package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/9/4 下午4:15
 */
public class TeemoAttacking {

    public static void main(String[] args) {
//        int[] timeSeries = {1, 2};
//        int[] timeSeries = {1, 2, 3, 4, 5};
        int[] timeSeries = {1, 4};
//        int duration = 5;
        int duration = 2;
        System.out.println(findPositionDuration(timeSeries, duration));
    }

    private static int findPositionDuration(int[] timeSeries, int duration) {
        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return total + duration;
    }
}
