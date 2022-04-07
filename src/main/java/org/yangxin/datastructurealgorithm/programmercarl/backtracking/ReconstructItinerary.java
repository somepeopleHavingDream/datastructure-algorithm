package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.*;

/**
 * @author yangxin
 * 2022/4/5 10:53
 */
@SuppressWarnings("AlibabaRemoveCommentedCode")
public class ReconstructItinerary {

    public static void main(String[] args) {
//        List<String> list1 = Arrays.asList("MUC", "LHR");
//        List<String> list2 = Arrays.asList("JFK", "MUC");
//        List<String> list3 = Arrays.asList("SFO", "SJC");
//        List<String> list4 = Arrays.asList("LHR", "SFO");
//        List<List<String>> tickets = Arrays.asList(list1, list2, list3, list4);

//        List<String> list1 = Arrays.asList("JFK", "SFO");
//        List<String> list2 = Arrays.asList("JFK", "ATL");
//        List<String> list3 = Arrays.asList("SFO", "ATL");
//        List<String> list4 = Arrays.asList("ATL", "JFK");
//        List<String> list5 = Arrays.asList("ATL", "SFO");
//        List<List<String>> tickets = Arrays.asList(list1, list2, list3, list4, list5);

        List<String> list1 = Arrays.asList("JFK", "KUL");
        List<String> list2 = Arrays.asList("JFK", "NRT");
        List<String> list3 = Arrays.asList("NRT", "JFK");
        List<List<String>> tickets = Arrays.asList(list1, list2, list3);

        System.out.println(findItinerary(tickets));
    }

    private static final List<String> PATH = new LinkedList<>();
    private static final Map<String, Map<String, Integer>> MAP = new LinkedHashMap<>();

    private static List<String> findItinerary(List<List<String>> tickets) {
        PATH.clear();
        MAP.clear();

        PATH.add("JFK");

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (!MAP.containsKey(from)) {
                Map<String, Integer> map = new TreeMap<>();
                map.put(to, 1);

                MAP.put(from, map);
            } else {
                Map<String, Integer> map = MAP.get(from);
                map.merge(to, 1, Integer::sum);
            }
        }

        backtracking(tickets.size());
        return PATH;
    }

    private static boolean backtracking(int tickets) {
        // 终止条件
        if (PATH.size() == tickets + 1) {
            return true;
        }

        // 单层for循环逻辑
        String from = PATH.get(PATH.size() - 1);
        Map<String, Integer> toMap = MAP.get(from);
        if (toMap == null) {
            return false;
        }

        for (Map.Entry<String, Integer> entry : toMap.entrySet()) {
            String to = entry.getKey();
            Integer count = entry.getValue();

            // 处理结点
            if (count <= 0) {
                continue;
            }

            PATH.add(to);
            toMap.put(to, --count);
            // 递归
            if (backtracking(tickets)) {
                return true;
            }
            // 回溯
            PATH.remove(PATH.size() - 1);
            toMap.put(to, ++count);
        }

        return false;
    }
}
