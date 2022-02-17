package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/2/17 20:42
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果该元素是遍历的第一个元素
                if (i == 0 && j == 0) {
                    result[0][0] = grid[0][0];
                    continue;
                }

                // 如果该元素处在最上面一行
                if (i == 0) {
                    result[i][j] = grid[i][j] + result[i][j - 1];
                    continue;
                }

                // 如果该元素在最左边
                if (j == 0) {
                    result[i][j] = grid[i][j] +result[i - 1][j];
                    continue;
                }

                result[i][j] = grid[i][j] + Math.min(result[i][j - 1], result[i - 1][j]);
            }
        }

        return result[result.length - 1][result[0].length - 1];
    }
}
