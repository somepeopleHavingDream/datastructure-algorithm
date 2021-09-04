package org.yangxin.datastructurealgorithm.leetcode.tag.array.easy;

/**
 * @author yangxin
 * 2021/9/4 下午3:46
 */
public class IslandPerimeter {

    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 1, 0, 0},
//                {1, 1, 1, 0},
//                {0, 1, 0, 0},
//                {1, 1, 0, 0}
//        };
        int[][] grid = {{1, 0}};
        System.out.println(islandPerimeter(grid));
    }

    private static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int nearWater = 0;
                // 左边是否临水
                if (j - 1 < 0 || grid[i][j - 1] == 0) {
                    nearWater++;
                }
                // 右边是否临水
                if (j + 1 >= grid[i].length || grid[i][j + 1] == 0) {
                    nearWater++;
                }
                // 上边是否临水
                if (i - 1 < 0 || grid[i - 1][j] == 0) {
                    nearWater++;
                }
                // 下边是否临水
                if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
                    nearWater++;
                }

                perimeter += nearWater;
            }
        }

        return perimeter;
    }
}
