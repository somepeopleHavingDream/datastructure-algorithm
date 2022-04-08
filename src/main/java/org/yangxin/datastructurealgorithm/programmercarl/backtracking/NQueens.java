package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxin
 * 2022/4/7 21:26
 */
@SuppressWarnings({"AlibabaLowerCamelCaseVariableNaming", "AlibabaClassNamingShouldBeCamel"})
public class NQueens {

    public static void main(String[] args) {
        System.out.println(solveNQueues(4));
        System.out.println(solveNQueues(1));
    }

    private static final List<List<String>> RESULT = new LinkedList<>();

    private static List<List<String>> solveNQueues(int n) {
        RESULT.clear();

        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }

        backtracking(n, 0, chessboard);
        return RESULT;
    }

    private static void backtracking(int n, int row, char[][] chessboard) {
        // 终止条件
        if (row == n) {
            RESULT.add(array2List(chessboard));
            return;
        }

        // 单层循环逻辑
        for (int i = 0; i < n; i++) {
            // 处理结点
            if (cant(chessboard, row, i)) {
                continue;
            }
            chessboard[row][i] = 'Q';

            // 递归
            backtracking(n, row + 1, chessboard);
            // 回溯
            chessboard[row][i] = '.';
        }
    }

    private static boolean cant(char[][] chessboard, int row, int col) {
        // 列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return true;
            }
        }

        // 45度
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return true;
            }
        }

        // 135度
        int n = chessboard.length;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return true;
            }
        }

        return false;
    }

    private static List<String> array2List(char[][] chessboard) {
        List<String> result = new LinkedList<>();
        for (char[] row : chessboard) {
            result.add(new String(row));
        }
        return result;
    }
}
