package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yangxin
 * 2021/9/21 下午3:42
 */
@SuppressWarnings("OptionalGetWithoutIsPresent")
public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = {"KFC"};
//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC"};
//        String[] list2 = {"KNN", "KFC", "Burger King", "Tapioca Express", "Shogun"};
//        String[] list2 = {"KFC", "Burger King", "Tapioca Express", "Shogun"};
//        String[] list2 = {"KFC", "Shogun", "Burger King"};
//        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    private static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        Set<String> set2 = map2.keySet();

        int minimumIndexSum = Integer.MAX_VALUE;
        Map<Integer, List<String>> strListByIndexSumMap = new LinkedHashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if (!set2.contains(list1[i])) {
                continue;
            }

            int indexSum = i + map2.get(list1[i]);
            if (indexSum <= minimumIndexSum) {
                minimumIndexSum = indexSum;
                List<String> strList = strListByIndexSumMap.get(indexSum);

                if (strList != null) {
                    strList.add(list1[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(list1[i]);
                    strListByIndexSumMap.put(indexSum, list);
                }
            }
        }

        Integer integer = strListByIndexSumMap.keySet().stream().min(Integer::compareTo).get();
        List<String> strings = strListByIndexSumMap.get(integer);
        String[] output = new String[strings.size()];
        strings.toArray(output);

        return output;
    }
}
