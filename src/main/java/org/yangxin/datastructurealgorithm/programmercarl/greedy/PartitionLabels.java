package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/12 11:16
 */
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> result = new LinkedList<>();

        // 统计每个字母在数组中出现的最后位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // 遍历数组，如果当前位置等于当前最大位置，则计数
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
