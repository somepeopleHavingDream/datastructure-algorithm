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

        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];

        // dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i])

        for (int stone : stones) {
            for (int j = bagSize; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        return sum - dp[bagSize] - dp[bagSize];
    }
}
