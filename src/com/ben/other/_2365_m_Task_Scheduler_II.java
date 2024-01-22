package com.ben.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2365_m_Task_Scheduler_II {

    public static void main(String[] args) {
        int[] tasks = new int[]{1, 2, 1, 2, 3, 1};
        int space = 3;


        Solution s = new Solution();
        System.out.println(s.taskSchedulerII(tasks, space));
    }

    static class Solution {
        public long taskSchedulerII(int[] tasks, int space) {
            long totalNeedDay = 0;
            Map<Integer, Long> map = new HashMap<>();

            for (int t : tasks) {
                Long lastDay = map.get(t);
                if (lastDay == null) {
                    //We didn't do the same type before
                    //Take one day to finish the task
                    totalNeedDay++;
                } else {
                    //We did the same type before

                    //We need to wait for space day (cool down) to be able to do the same type task
                    long newLastDay = lastDay + space;

                    //Check if we are in cool down, if yes, we need to wait for cool down
                    if (totalNeedDay < newLastDay) {
                        totalNeedDay = newLastDay;
                    }

                    //Take one day to finish the task
                    totalNeedDay++;
                }

                map.put(t, totalNeedDay);
            }

            return totalNeedDay;
        }
    }
}
