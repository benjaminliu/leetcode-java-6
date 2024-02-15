package com.ben.greedy;

public class _0122_m_Best_Time_to_Buy_and_Sell_Stock_II {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int sum = 0;

            int min = prices[0];

            for (int i = 1; i < prices.length; i++) {
                int cur = prices[i];
                if (cur == min) {
                    continue;
                }
                if (cur > min) {
                    sum += cur - min;
                }

                min = cur;
            }

            return sum;
        }
    }


    class Solution1 {
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                result += Math.max(prices[i] - prices[i - 1], 0);
            }
            return result;
        }
    }
}
