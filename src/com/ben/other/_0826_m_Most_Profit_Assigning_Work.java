package com.ben.other;

import java.util.Arrays;

public class _0826_m_Most_Profit_Assigning_Work {
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int[][] jobs = new int[difficulty.length][2];

            for (int i = 0; i < jobs.length; i++) {
                jobs[i][0] = difficulty[i];
                jobs[i][1] = profit[i];
            }

            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
            Arrays.sort(worker);

            int res = 0;

            int jobIdx = 0;

            //Max profit for each worker
            int maxProfit = 0;

            for (int i = 0; i < worker.length; i++) {
                //if a worker's ability is 6,  the default profit is the maxProfit of job with difficulty lower than 6(because he can work for any job lower than 6)
                int ability = worker[i];
                while (jobIdx < difficulty.length && ability >= jobs[jobIdx][0]) {
                    maxProfit = Math.max(jobs[jobIdx][1], maxProfit);
                    jobIdx++;
                }

                res += maxProfit;
            }

            return res;
        }
    }
}
