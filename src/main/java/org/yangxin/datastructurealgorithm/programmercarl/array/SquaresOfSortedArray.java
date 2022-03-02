package org.yangxin.datastructurealgorithm.programmercarl.array;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/3/2 22:18
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
//        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0, j = nums.length - 1;
        for (int k = nums.length - 1; k >= 0 ; k--) {
            int iSquares = nums[i] * nums[i];
            int jSquares = nums[j] * nums[j];

            if (iSquares >= jSquares) {
                result[k] = iSquares;
                i++;
            } else {
                result[k] = jSquares;
                j--;
            }
        }

        return result;
    }
}
