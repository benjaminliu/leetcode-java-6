package com.ben.dp.stock;

public class _0121_e_Best_Time_to_Buy_and_Sell_Stock {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int[][] dp = new int[prices.length][2];
            for (int i = 0; i < prices.length; i++) {
                dp[i] = new int[2];
            }

            //dp[n][0]: buy stock, the min the better
            dp[0][0] = prices[0];
            //dp[n][1]: sell stock, the max the better
            dp[0][1] = 0;

            for (int i = 1; i < prices.length; i++) {
                //if today's price is lower than previous, buy today
                dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
                //if today sell make more profit the previous, sell today
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
            }

            return dp[prices.length - 1][1];
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            int[][] dp = new int[n][2];
            //Buy stock, how many cash, because we spend money to buy stock, so current cash is negative
            dp[0][0] = -prices[0];
            //sell stock
            dp[0][1] = 0;

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }

            return dp[n - 1][1];
        }
    }
}
