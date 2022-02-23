package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yangxin
 * 2022/2/22 21:51
 */
@SuppressWarnings("ConstantConditions")
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        int k = 2;

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    private static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
