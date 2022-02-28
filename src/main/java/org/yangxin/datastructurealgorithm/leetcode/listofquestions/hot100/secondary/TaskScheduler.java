package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author yangxin
 * 2022/2/27 18:12
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class TaskScheduler {

    public static void main(String[] args) {
//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        int n = 2;

//        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//        int n = 0;

        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }

    private static int leastInterval(char[] tasks, int n) {
        // 统计每个任务出现的频数
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // 找到任务最多的频数
        Arrays.sort(count);

        // 计算出频数最大的任务数
        int num = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] != count[25]) {
                break;
            }

            num++;
        }

        return Math.max((count[25] - 1) * (n + 1) + num, tasks.length);
    }
}
