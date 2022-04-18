package org.yangxin.datastructurealgorithm.programmercarl.dp;

/**
 * @author yangxin
 * 2022/4/18 11:56
 */
@SuppressWarnings("SameParameterValue")
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4}, value = {15, 20, 30};
        System.out.println(one(weight, value, 4));
        System.out.println(two(weight, value, 4));
    }

    private static int one(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[weight.length - 1][bagSize];
    }

    private static int two(int[] weight, int[] value, int bagSize) {
        // 编写dp表
        int[] dp = new int[bagSize + 1];
        // 编写递推公式 dp[j] = Math.max(dp[j - 1], dp[j - weight[i]] + value[i]
        // 初始化
        dp[0] = 0;

        // 遍历顺序
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        return dp[bagSize];
    }
}
