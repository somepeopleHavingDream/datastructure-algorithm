package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/8 11:25
 */
public class JumpGameIi {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {2, 3, 0, 1, 4};
//        int[] nums = {2, 1};
//        int[] nums = {1, 2, 1, 1, 1};

        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int result = 0;

        // 下一步的最远位置
        int nextMaxIndex = 0;
        // 当前步的最远位置
        int currentMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 计算下一步的最远位置
            nextMaxIndex = Math.max(i + nums[i], nextMaxIndex);

            if (i != currentMaxIndex) {
                continue;
            }

            // 如果已经走到了当前步的最远距离
            if (i == nums.length - 1) {
                return result;
            }

            result++;
            currentMaxIndex = nextMaxIndex;
            if (currentMaxIndex >= nums.length - 1) {
                return result;
            }
        }

        return result;
    }
}
