package org.yangxin.datastructurealgorithm.leetcode.listofquestions.foroffer.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * @author yangxin
 * 2020/10/15 16:37
 */
public class FirstUniqChar {

    private static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
