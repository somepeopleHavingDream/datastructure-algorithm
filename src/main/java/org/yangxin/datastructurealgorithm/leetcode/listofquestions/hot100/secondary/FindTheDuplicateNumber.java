package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/22 20:57
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
//        int[] nums = {1, 3, 4, 2, 2};
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }

    private static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }

                return nums[slow];
            }
        }
    }
}
