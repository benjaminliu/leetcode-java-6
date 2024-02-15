package com.ben.greedy;

public class _0121_e_Best_Time_to_Buy_and_Sell_Stock {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int max = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int cur = prices[i];
                if (cur < min) {
                    min = cur;
                } else {
                    max = Math.max(max, cur - min);
                }
            }

            return max;
        }
    }
}
