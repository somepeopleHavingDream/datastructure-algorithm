package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/8 11:25
 */
public class JumpGameIi {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int result = 0;

        int nextMaxStep = 0;
        int currentStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxStep = Math.max(i + nums[i], nextMaxStep);
            if (i == currentStep) {
                result++;
                currentStep = nextMaxStep;
            }
        }

        return result;
    }
}
