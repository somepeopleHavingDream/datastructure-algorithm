package org.yangxin.datastructurealgorithm.programmercarl.greedy;

/**
 * @author yangxin
 * 2022/4/11 15:45
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
//        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
//        int[] gas = {2, 3, 4}, cost = {3, 4, 4};
        int[] gas = {3, 1, 1}, cost = {1, 2, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int currentRestSum = 0;
        int totalRestSum = 0;
        int start = 0;

        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int rest = gas[i] - cost[i];

            currentRestSum += rest;
            totalRestSum += rest;
            if (currentRestSum < 0) {
                currentRestSum = 0;
                start = i + 1;
            }
        }

        return totalRestSum >= 0 ? start : -1;
    }
}
