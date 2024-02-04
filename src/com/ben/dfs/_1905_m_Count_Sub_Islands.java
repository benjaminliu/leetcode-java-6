package com.ben.dfs;

public class _1905_m_Count_Sub_Islands {

    public static void main(String[] args) {
//        int[][] grid1 = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
//        int[][] grid2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};

        int[][] grid1 = new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}};
        int[][] grid2 = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}};

        System.out.println(new Solution().countSubIslands(grid1, grid2));
    }

    static class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int res = 0;

            for (int i = 0; i < grid2.length; i++) {
                for (int j = 0; j < grid2[0].length; j++) {
                    if (grid2[i][j] == 1) {
                        if (dfs(grid1, grid2, i, j)) {
                            res++;
                        }
                    }
                }
            }

            return res;
        }

        private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
            //check border, is out of border, stop, return true
            if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length) {
                return true;
            }

            //Current is not an island, stop, return true
            if (grid2[i][j] != 1) {
                return true;
            }

            //Check if current is an island in grid1
            boolean grid1IsIsland = grid1[i][j] == 1;

            //change current to a non island, so that we never come back again
            grid2[i][j] = 0;

            //we must make sure to change every nodes in current island to non islands,
            //otherwise, the unchanged node may be considered as a different island

            boolean right = dfs(grid1, grid2, i + 1, j);

            boolean left = dfs(grid1, grid2, i - 1, j);

            boolean up = dfs(grid1, grid2, i, j + 1);

            boolean down = dfs(grid1, grid2, i, j - 1);

            return right && left && up && down && grid1IsIsland;
        }
    }
}
