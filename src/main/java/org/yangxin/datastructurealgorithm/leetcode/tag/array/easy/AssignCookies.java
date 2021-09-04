package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

import java.util.Arrays;

/**
 * @author yangxin
 * 2021/9/4 下午3:26
 */
public class AssignCookies {

    public static void main(String[] args) {
        int[] g = {1, 2};
//        int[] g = {1, 2, 3};
        int[] s = {1, 2, 3};
//        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int maxContent = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                maxContent++;
                i++;
            }

            j++;
        }

        return maxContent;
    }
}
