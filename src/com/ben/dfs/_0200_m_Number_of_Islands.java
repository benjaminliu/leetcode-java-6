package com.ben.dfs;

public class _0200_m_Number_of_Islands {
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int i, int j) {
            //check border, is out of border, stop
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }

            //Current is not an island, stop
            if (grid[i][j] != '1') {
                return;
            }

            //change current to a non island, so that we never come back again
            grid[i][j] = '0';

            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
