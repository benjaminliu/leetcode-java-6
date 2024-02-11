package com.ben.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _0317_h_Shortest_Distance_from_All_Buildings {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(new Solution().shortestDistance(grid));
    }

    static public class Solution {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1},};

        public int shortestDistance(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return -1;
            }

            int m = grid.length;
            int n = grid[0].length;

            int buildingCount = 0;

            // distance sum of all building to dists[x][y]
            int[][] dists = new int[m][n];
            // how many buildings can reach nums[x][y]
            int[][] nums = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        buildingCount++;
                        //calculate the distance from current node to other nodes
                        bfs(grid, dists, nums, i, j);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //Current node is an island, and current island can reach to all the building
                    if (grid[i][j] == 0 && nums[i][j] == buildingCount) {
                        min = Math.min(min, dists[i][j]);
                    }
                }
            }

            if (min != Integer.MAX_VALUE) {
                return min;
            }

            return -1;
        }

        private void bfs(int[][] grid, int[][] dists, int[][] nums, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, j});

            boolean[][] visited = new boolean[m][n];

            //Distant to building [i][j]
            int distant = 0;
            while (!queue.isEmpty()) {
                distant++;
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int[] cur = queue.poll();
                    for (int l = 0; l < 4; l++) {
                        int x = cur[0] + dirs[l][0];
                        int y = cur[1] + dirs[l][1];

                        // reached to an unvisited island, the distance to it and add the reached building count to it
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                            visited[x][y] = true;
                            dists[x][y] += distant;
                            nums[x][y]++;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
