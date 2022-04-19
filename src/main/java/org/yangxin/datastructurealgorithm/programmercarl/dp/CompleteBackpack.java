package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/19 11:19
 */
@SuppressWarnings("SameParameterValue")
public class CompleteBackpack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        System.out.println(completeBackpack(weight, value, 4));
    }

    private static int completeBackpack(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        return dp[bagWeight];
    }
}
