package com.ben.unionfind;

public class _0130_m_Surrounded_Regions {
    class Solution {
        private final int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        private final int O = 'O';
        private final int X = 'X';

        public void solve(char[][] board) {
            if (board.length == 0) {
                return;
            }

            int m = board.length;
            int n = board[0].length;


            int dummy = m * n;
            //Add 1 to give a room to dummy
            UF uf = new UF(dummy + 1);

            //left and right edges
            for (int i = 0; i < m; i++) {
                if (board[i][0] == O) {
                    uf.union(calcUFIndex(i, 0, n), dummy);
                }

                if (board[i][n - 1] == O) {
                    uf.union(calcUFIndex(i, n - 1, n), dummy);
                }
            }

            //top and bottom edges
            for (int j = 0; j < n; j++) {
                if (board[0][j] == O) {
                    uf.union(calcUFIndex(0, j, n), dummy);
                }

                if (board[m - 1][j] == O) {
                    uf.union(calcUFIndex(m - 1, j, n), dummy);
                }
            }

            //loop all the node beside edges
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == O) {
                        for (int k = 0; k < 4; k++) {
                            int x = i + directions[k][0];
                            int y = j + directions[k][1];
                            if (board[x][y] == O) {
                                uf.union(calcUFIndex(x, y, n), calcUFIndex(i, j, n));
                            }
                        }
                    }
                }
            }

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (!uf.connected(dummy, calcUFIndex(i, j, n))) {
                        board[i][j] = X;
                    }
                }
            }
        }

        private int calcUFIndex(int row, int column, int rowCount) {
            return row * rowCount + column;
        }
    }
}
