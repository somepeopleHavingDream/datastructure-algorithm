package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/26 18:26
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = {1, 1};

        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, minHeight * (j - i + 1));
        }

        return max;
    }
}
