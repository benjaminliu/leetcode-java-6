package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class _0051_h_N_Queens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>(n);

            char[][] board = new char[n][n];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = '.';
                }
            }

            helper(board, 0, res);

            return res;
        }

        private void helper(char[][] board, int row, List<List<String>> res) {
            if (row == board.length) {
                List<String> list = new ArrayList<>(board.length);
                for (char[] chars : board) {
                    list.add(new String(chars));
                }
                res.add(list);
                return;
            }

            for (int i = 0; i < board.length; i++) {
                if (isvalid(board, row, i)) {
                    board[row][i] = 'Q';
                    helper(board, row + 1, res);
                    board[row][i] = '.';
                }
            }
        }

        private boolean isvalid(char[][] board, int row, int col) {
            int r = row;
            int c = col;

            //Colum
            while (r >= 0) {
                if (board[r][c] == 'Q') {
                    return false;
                }

                r--;
            }

            r = row;
            c = col;
            //diagonal to northwest
            while (r >= 0 && c >= 0) {
                if (board[r][c] == 'Q') {
                    return false;
                }

                r--;
                c--;
            }

            r = row;
            c = col;
            //diagonal to northeast
            while (r >= 0 && c < board.length) {
                if (board[r][c] == 'Q') {
                    return false;
                }
                r--;
                c++;
            }

            return true;
        }
    }
}
