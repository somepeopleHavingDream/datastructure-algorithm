package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/11 16:12
 */
public class Candy {

    public static void main(String[] args) {
//        int[] ratings = {1, 0, 2};
        int[] ratings = {1, 2, 2};

        System.out.println(candy(ratings));
    }

    private static int candy(int[] ratings) {
        int length = ratings.length;

        // 考虑当前孩子的评分比左边高的情况
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            // 如果当前孩子的评分比左边高
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }

        // 考虑当前孩子的评分比右边高的情况
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }

        return Arrays.stream(result).sum();
    }
}
