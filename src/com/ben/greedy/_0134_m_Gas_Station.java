package com.ben.greedy;

public class _0134_m_Gas_Station {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curLeft = 0;
            int totalLeft = 0;
            int start = 0;
            for (int i = 0; i < gas.length; i++) {
                curLeft += gas[i] - cost[i];
                totalLeft += gas[i] - cost[i];
                //Cannot reach next stop, start over again
                if (curLeft < 0) {
                    start = (i + 1);
                    curLeft = 0;
                }
            }
            //gas cannot cover cost
            if (totalLeft < 0) return -1;
            return start;
        }
    }
}
