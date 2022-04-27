package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/26 16:16
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    private static int trap(int[] height) {
        /*
            当前柱子能接的雨水数等于左边最高柱子和右边最高柱子两者之间的最小高度，再减去当前柱子高度
         */

        // 定义dp及其下标的含义
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        // 确定递推公式
        // 初始化
        leftMax[0] = height[0];
        rightMax[length - 1] = height[length - 1];

        // 确定遍历顺序
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int current = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (current > 0) {
                sum += current;
            }
        }

        return sum;
    }
}
