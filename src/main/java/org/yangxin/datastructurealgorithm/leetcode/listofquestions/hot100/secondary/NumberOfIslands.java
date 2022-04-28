package org.yangxin.datastructurealgorithm.leetcode.listofquestions.hot100.secondary;

/**
 * @author yangxin
 * 2022/4/28 16:09
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println(numIsLands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
        System.out.println(numIsLands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));

        // 1
        System.out.println(numIsLands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        }));
    }

    private static int numIsLands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 跳过所有的水和被感染的岛屿
                if (grid[i][j] == '0' || grid[i][j] == '2') {
                    continue;
                }

                // 如果该岛未被感染
                if (grid[i][j] == '1') {
                    // 感染与之相连的岛屿
                    infect(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private static void infect(char[][] grid, int i, int j) {
        // 编写终止条件
        // 检查边界条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }
        // 检查当前位置是否是水或者已被感染
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        // 编写单层递归逻辑
        // 感染当前岛屿
        grid[i][j] = '2';
        // 感染周围（上，左，下，右）
        infect(grid, i - 1, j);
        infect(grid, i, j - 1);
        infect(grid, i + 1, j);
        infect(grid, i, j + 1);
    }
}
