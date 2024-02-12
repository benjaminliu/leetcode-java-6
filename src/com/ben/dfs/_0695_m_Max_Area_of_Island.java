package com.ben.dfs;

public class _0695_m_Max_Area_of_Island {
    class Solution {

        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int count = dfs(grid, i, j);
                        max = Math.max(max, count);
                    }
                }
            }

            return max;
        }

        private int dfs(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return 0;
            }
            if (grid[x][y] == 0) {
                return 0;
            }

            //change to non-island, to prevent duplication
            grid[x][y] = 0;

            return 1 + dfs(grid, x - 1, y) + dfs(grid, x + 1, y) + dfs(grid, x, y - 1) + dfs(grid, x, y + 1);
        }
    }
}
