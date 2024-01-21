package com.ben.other;

public class _1779_e_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate {

    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int minDistance = Integer.MAX_VALUE;
            int minIdx = -1;

            for (int i = 0; i < points.length; i++) {
                int[] p = points[i];
                if (p[0] != x && p[1] != y) {
                    continue;
                }

                int distance;
                if (p[0] == x) {
                    distance = Math.abs(p[1] - y);
                } else {
                    distance = Math.abs(p[0] - x);
                }

                if (distance < minDistance) {
                    minDistance = distance;
                    minIdx = i;
                }
            }
            return minIdx;
        }
    }
}
