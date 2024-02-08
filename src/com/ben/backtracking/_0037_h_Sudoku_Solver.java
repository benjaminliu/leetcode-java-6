package com.ben.backtracking;

public class _0037_h_Sudoku_Solver {

    class Solution {
        public void solveSudoku(char[][] board) {
            helper(board);
        }

        private boolean helper(char[][] board) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (board[r][c] != '.') {
                        continue;
                    }

                    for (char i = '1'; i <= '9'; i++) {
                        if (isValid(board, r, c, i)) {
                            board[r][c] = i;
                            if (helper(board)) {
                                return true;
                            }
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, int val) {
            // 同行是否重复
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == val) {
                    return false;
                }
            }
            // 同列是否重复
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == val) {
                    return false;
                }
            }
            // 9宫格里是否重复
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == val) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
