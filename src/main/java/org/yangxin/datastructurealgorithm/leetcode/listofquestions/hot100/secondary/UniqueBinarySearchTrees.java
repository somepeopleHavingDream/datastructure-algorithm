package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/15 21:26
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode", "SameParameterValue"})
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
//        System.out.println(numTrees(3));
        System.out.println(numTrees(1));
    }

    private static int numTrees(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            if (i == 0 || i == 1) {
                result[i] = 1;
                continue;
            }

            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += result[j] * result[i - 1 - j];
            }

            result[i] = sum;
        }

        return result[n];
    }
}
