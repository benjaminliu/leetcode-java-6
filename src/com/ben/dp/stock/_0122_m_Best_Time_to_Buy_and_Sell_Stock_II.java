package com.ben.dp.stock;

public class _0122_m_Best_Time_to_Buy_and_Sell_Stock_II {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];

            //Buy stock, how many cash, because we spend money to buy stock, so current cash is negative
            dp[0][0] = -prices[0];
            //Sell stock
            dp[0][1] = 0;

            for (int i = 1; i < n; i++) {
                // Hold stock,
                // if we don't buy stock, the cash is previous day's cash(hold stock)
                // if we buy stock, the cash is previous day's cash(not hold stock) - today's stock
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);

                // Do not hold stock
                // if we don't sell stock, the cash is previous day's cash (not hold stock)
                // if we sell stock, the cash is previous day's cash (hold stock) + today's stock price
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }

            return dp[n - 1][1];
        }
    }
}
