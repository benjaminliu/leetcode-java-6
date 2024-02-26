package com.ben.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0406_m_Queue_Reconstruction_by_Height {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {

            //Sort by height desc,
            //If height equals, sort by order acs
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }

                return b[0] - a[0];
            });

            List<int[]> list = new ArrayList<>();
            for (int[] p : people) {
                list.add(p[1], p);
            }

            return list.toArray(new int[people.length][]);
        }
    }
}
