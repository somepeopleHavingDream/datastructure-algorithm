package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/8 11:25
 */
public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
