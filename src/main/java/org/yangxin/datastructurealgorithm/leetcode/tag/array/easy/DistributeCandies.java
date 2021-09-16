package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yangxin
 * 2021/9/16 下午9:11
 */
@SuppressWarnings("CommentedOutCode")
public class DistributeCandies {

    public static void main(String[] args) {
        int[] candyType = {6, 6, 6, 6};
//        int[] candyType = {1, 1, 2, 3};
//        int[] candyType = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(candyType));
    }

    private static int distributeCandies(int[] candyType) {
        Set<Integer> typeSet = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        int canEatNum = candyType.length / 2;

        return Math.min(typeSet.size(), canEatNum);
    }
}
