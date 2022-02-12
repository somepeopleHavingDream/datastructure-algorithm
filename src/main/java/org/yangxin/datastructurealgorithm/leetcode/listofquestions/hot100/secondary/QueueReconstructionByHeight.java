package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangxin
 * 2022/2/12 15:05
 */
public class QueueReconstructionByHeight {

    public static void main(String[] args) {
//        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] people = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    private static int[][] reconstructQueue(int[][] people) {
        // 高度降序，排位升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> result = new ArrayList<>(people.length);
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(people);
    }
}
