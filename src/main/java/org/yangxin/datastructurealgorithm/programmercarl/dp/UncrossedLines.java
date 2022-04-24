package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/24 21:20
 */
public class UncrossedLines {

    public static void main(String[] args) {
//        int[] nums1 = {1, 4, 2}, nums2 = {1, 2, 4};
//        int[] nums1 = {2, 5, 1, 2, 5}, nums2 = {10, 5, 2, 1, 5, 2};
        int[] nums1 = {1, 3, 7, 1, 7, 5}, nums2 = {1, 9, 2, 5, 1};
        System.out.println(maxUncrossedLines(nums1, nums2));
    }

    private static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];

        int result = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
