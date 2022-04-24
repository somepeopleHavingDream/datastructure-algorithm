package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/22 14:13
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1}, nums2 = {3, 2, 1, 4, 7};
//        int[] nums1 = {0, 0, 0, 0, 0}, nums2 = {0, 0, 0, 0, 0};
        // 2
//        int[] nums1 = {0, 1, 1, 1, 1}, nums2 = {1, 0, 1, 0, 1};
//        int[] nums1 = {1, 2, 3, 2, 8}, nums2 = {5, 6, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));
    }

    private static int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1][length2];

        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                result = 1;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0]) {
                dp[0][i] = 1;
                result = 1;
            }
        }

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (nums1[i] != nums2[j]) {
                    continue;
                }

                dp[i][j] = dp[i - 1][j - 1] + 1;
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}