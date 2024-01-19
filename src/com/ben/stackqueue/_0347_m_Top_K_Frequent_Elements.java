package com.ben.stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0347_m_Top_K_Frequent_Elements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length == k) {
                return nums;
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int[] temp = new int[]{entry.getKey(), entry.getValue()};
                pq.offer(temp);

                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = pq.poll()[0];
            }
            return res;
        }
    }
}
