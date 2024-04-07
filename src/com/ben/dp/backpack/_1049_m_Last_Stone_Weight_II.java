package com.ben.dp.backpack;

import java.util.Arrays;

public class _1049_m_Last_Stone_Weight_II {
    class Solution {

        /**
         * Separate the stone into 2 parts, so that their diff is the smallest.
         */
        public int lastStoneWeightII(int[] stones) {
            int sum = Arrays.stream(stones).sum();

            int bagSize = sum / 2;
            int n = stones.length;
            int[][] dp = new int[n][bagSize + 1];

            for (int i = stones[0]; i <= bagSize; i++) {
                dp[0][i] = stones[0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= bagSize; j++) {
                    if (stones[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                    }
                }
            }

            int smallPartSum = dp[n - 1][bagSize];
            int bigPartSum = sum - smallPartSum;
            return bigPartSum - smallPartSum;
        }
    }
}
