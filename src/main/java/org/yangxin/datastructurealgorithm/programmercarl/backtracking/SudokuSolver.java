package org.yangxin.datastructurealgorithm.programmercarl.backtracking;

import java.util.Arrays;

/**
 * @author yangxin
 * 2022/4/7 22:16
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    private static void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private static boolean backtracking(char[][] board) {
        // 终止条件（无）
        // 单层循环逻辑
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 处理结点
                if (board[i][j] != '.') {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    char value = (char) (k + '0');
                    if (cant(board, i, j, value)) {
                        continue;
                    }
                    board[i][j] = value;

                    // 递归
                    if (backtracking(board)) {
                        return true;
                    }
                    // 回溯
                    board[i][j] = '.';
                }
                
                return false;
            }
        }
        
        return true;
    }

    private static boolean cant(char[][] board, int row, int col, char value) {
        // 行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return true;
            }
        }
        
        // 列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return true;
            }
        }
        
        // 9宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return true;
                }
            }
        }

        return false;
    }
}
