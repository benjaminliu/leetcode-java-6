package com.ben.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0286_m_Walls_and_Gates {

    static
    class Solution {
        private static final int EMPTY = Integer.MAX_VALUE;
        private static final int GATE = 0;
        private static final List<int[]> DIRECTIONS = Arrays.asList(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            if (m == 0) return;
            int n = rooms[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    // enqueue all the gate
                    if (rooms[row][col] == GATE) {
                        q.add(new int[]{row, col});
                    }
                }
            }

            // bsf
            while (!q.isEmpty()) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];

                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];

                    //outside the border
                    if (r < 0 || c < 0 || r >= m || c >= n) {
                        continue;
                    }
                    //Has a shorten path
                    if (rooms[r][c] < rooms[row][col] + 1) {
                        continue;
                    }
                    rooms[r][c] = rooms[row][col] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }
    }

}
