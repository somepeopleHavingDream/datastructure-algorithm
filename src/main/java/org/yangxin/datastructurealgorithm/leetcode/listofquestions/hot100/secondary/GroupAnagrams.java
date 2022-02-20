package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.*;

/**
 * @author yangxin
 * 2022/2/20 14:26
 */
@SuppressWarnings({"unused", "SpellCheckingInspection", "AlibabaCollectionInitShouldAssignCapacity"})
public class GroupAnagrams {

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
        String[] strs = {"a"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(str);

                map.put(s, list);
            } else {
                List<String> list = map.get(s);
                list.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
