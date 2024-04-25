package com.ben.dp.stock;

public class _0123_h_Best_Time_to_Buy_and_Sell_Stock_III {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            //[0]: first time buy stock
            //[1]: first time sell stock
            //[2]: second time buy stock
            //[3]: second time sell stock
            int[][] dp = new int[n][4];

            dp[0][0] = -prices[0];
            dp[0][2] = -prices[0];

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);
                //after sell the stock for the first time, then buy new stock
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
            }

            return dp[n-1][3];
        }
    }
}
