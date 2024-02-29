package com.ben.greedy;

import java.util.ArrayList;
import java.util.List;

public class _0763_m_Partition_Labels {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> res = new ArrayList<>();
            int[] edge = new int[26];

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                edge[chars[i] - 'a'] = i;
            }

            int idx = 0;
            int last = -1;

            for (int i = 0; i < chars.length; i++) {
                idx = Math.max(idx, edge[chars[i] - 'a']);

                if (i == idx) {
                    res.add(i - last);
                    last = i;
                }
            }

            return res;
        }
    }
}
