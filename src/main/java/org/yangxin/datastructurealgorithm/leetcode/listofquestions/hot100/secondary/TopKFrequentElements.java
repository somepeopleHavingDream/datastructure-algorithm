package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.*;

/**
 * @author yangxin
 * 2022/2/26 13:39
 */
@SuppressWarnings({"unused", "AlibabaClassNamingShouldBeCamel", "AlibabaLowerCamelCaseVariableNaming", "AlibabaCollectionInitShouldAssignCapacity"})
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

//        int[] nums = {1};
//        int k = 1;

//        int[] nums = {1, 2};
//        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        // 计算每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        // 构建最大堆
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer value : map.values()) {
            queue.offer(value);
        }

        // 计算出需要返回的结果
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            Integer count = queue.poll();
            if (count == null) {
                break;
            }

            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();

                Integer key = entry.getKey();
                Integer value = entry.getValue();

                if (Objects.equals(count, value)) {
                    result[i] = key;
                    iterator.remove();
                    break;
                }
            }
        }

        return result;
    }
}
