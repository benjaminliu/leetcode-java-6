package com.ben.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056_m_Merge_Intervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int[] pre = intervals[0];
            List<int[]> res = new ArrayList<>();

            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                if (pre[1] >= cur[0]) {
                    pre[1] = Math.max(pre[1], cur[1]);
                } else {
                    res.add(pre);
                    pre = cur;
                }
            }
            res.add(pre);

            int[][] arrs = new int[res.size()][];
            for (int i = 0; i < res.size(); i++) {
                arrs[i] = res.get(i);
            }

            return arrs;
        }
    }
}
