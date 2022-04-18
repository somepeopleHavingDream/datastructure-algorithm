package org.yangxin.datastructurealgorithm.programmercarl.dp;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/18 17:13
 */
@SuppressWarnings("DuplicatedCode")
public class LastStoneWeightIi {

    public static void main(String[] args) {
//        int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones = {31, 26, 33, 21, 40};
        System.out.println(lastStoneWeightIi(stones));
    }

    private static int lastStoneWeightIi(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int dp = dp(stones, sum / 2);
        return (sum - dp) - dp;
    }

    private static int dp(int[] stones, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return dp[target];
    }
}
