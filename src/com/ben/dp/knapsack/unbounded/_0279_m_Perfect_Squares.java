package com.ben.dp.knapsack.unbounded;

public class _0279_m_Perfect_Squares {
    class Solution {
        public int numSquares(int n) {
            int max = Integer.MAX_VALUE;
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i] = max;
            }

            dp[0] = 0;

            for (int i = 1; i * i <= n; i++) {
                for (int j = i * i; j <= n; j++) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }

            return dp[n];
        }
    }
}
