package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/11 17:29
 */
public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        int[][] people = {{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}};

        // [[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]
//        int[][] people = {{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}};

        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    private static int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new LinkedList<>();

        Arrays.sort(people, ((o1, o2) ->  {
            int height = o2[0] - o1[0];
            if (height != 0) {
                return height;
            }

            return o1[1] - o2[1];
        }));

        for (int[] person : people) {
            int index = person[1];
            result.add(index, person);
        }

        int[][] returnArray = new int[0][];
        return result.toArray(returnArray);
    }
}
