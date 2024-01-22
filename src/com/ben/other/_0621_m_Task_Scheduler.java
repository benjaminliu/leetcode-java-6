package com.ben.other;

import java.util.Arrays;

public class _0621_m_Task_Scheduler {

    class Solution {
        public int leastInterval(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }

            int m = tasks.length;
            int[] counts = new int[26];
            /* Build the count array with frequency of each task */
            for (char c : tasks) {
                counts[c - 'A']++;
            }
            Arrays.sort(counts);

            /* Get maximum frequency task and calculate max idle slots*/
            int max = counts[25] - 1;
            int idleSlots = max * n;

            /* Iterate over rest of the array and reduce the idle space count */
            for (int i = 24; i >= 0; i--) {
                idleSlots -= Math.min(max, counts[i]);
            }
            /* Handle cases when spaces become negative */
            idleSlots = Math.max(0, idleSlots);
            return tasks.length + idleSlots;
        }
    }
}
