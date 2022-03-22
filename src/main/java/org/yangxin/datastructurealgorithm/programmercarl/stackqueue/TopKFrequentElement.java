package org.yangxin.datastructurealgorithm.programmercarl.stackqueue;

import java.util.*;

/**
 * @author yangxin
 * 2022/3/22 21:51
 */
@SuppressWarnings({"unused", "AlibabaLowerCamelCaseVariableNaming", "AlibabaClassNamingShouldBeCamel", "SameParameterValue"})
public class TopKFrequentElement {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {1};
        System.out.println(Arrays.toString(topKFrequent(nums, 1)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        // 统计入参数组中不同元素出现的次数
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        // 构建最小堆
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 那么剩下的k个元素即为频次最高的k个元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(heap.poll()).getKey();
        }

        return result;
    }
}
