package com.ben.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _0454_m_4Sum_II {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums1) {
                for (int j : nums2) {
                    int sum = i + j;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }

            for (int i : nums3) {
                for (int j : nums4) {
                    res += map.getOrDefault(0 - i - j, 0);
                }
            }

            return res;
        }
    }
}
