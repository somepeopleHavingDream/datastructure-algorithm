package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/3/19 下午8:49
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode"})
public class FindMajorityElement {

    public static int majorityElement(int[] nums) {
        // 入参校验
        if (nums == null) {
            return -1;
        }

        int winnerNum = 0;
        int winnerIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (winnerNum == 0) {
                winnerIndex = i;
                winnerNum++;
                continue;
            }

            if (nums[winnerIndex] == nums[i]) {
                winnerNum++;
            } else {
                winnerNum--;
            }
        }

        if (winnerNum > 0) {
            int count = 0;
            for (int num : nums) {
                if (num == nums[winnerIndex]) {
                    count++;

                    if (count > nums.length / 2) {
                        return nums[winnerIndex];
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(majorityElement(nums1));

        int[] nums2 = {3, 2};
        System.out.println(majorityElement(nums2));

        int[] nums3 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums3));

        int[] nums4 = {1, 2, 3};
        System.out.println(majorityElement(nums4));
    }
}
