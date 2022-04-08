package org.yangxin.datastructurealgorithm.programmercarl.greedy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/8 9:48
 */
public class AssignCookies {

    public static void main(String[] args) {
//        int[] g = {1, 2, 3}, s = {1, 1};
        int[] g = {1, 2}, s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for (int k : s) {
            if (j < g.length && g[j] <= k) {
                j++;
            }
        }
        return j;
    }
}
