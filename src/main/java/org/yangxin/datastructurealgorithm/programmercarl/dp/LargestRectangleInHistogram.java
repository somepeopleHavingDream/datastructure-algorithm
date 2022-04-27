package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/26 16:53
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleHistogram(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleHistogram(new int[]{2, 4}));
    }

    private static int largestRectangleHistogram(int[] heights) {
        // 定义dp及其下标含义（leftMinIndex[i]：比当前柱子高度低的，在左边的，第一个柱子的下标。rightMinIndex同理。）
        int length = heights.length;
        int[] leftMinIndex = new int[length];
        int[] rightMinIndex = new int[length];

        // 初始化dp
        leftMinIndex[0] = -1;
        rightMinIndex[length - 1] = length;

        // 确定遍历顺序
        for (int i = 1; i < length; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = leftMinIndex[left];
            }
            leftMinIndex[i] = left;
        }

        for (int i = length - 2; i >= 0; i--) {
            int right = i + 1;
            while (right < length && heights[right] >= heights[i]) {
                right = rightMinIndex[right];
            }
            rightMinIndex[i] = right;
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            int sum = heights[i] * (rightMinIndex[i] - leftMinIndex[i] - 1);
            result = Math.max(result, sum);
        }

        return result;
    }
}
