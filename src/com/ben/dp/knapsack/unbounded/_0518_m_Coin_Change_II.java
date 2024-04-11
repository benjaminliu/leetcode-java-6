package com.ben.dp.knapsack.unbounded;

public class _0518_m_Coin_Change_II {
    class Solution {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length][amount + 1];

            for (int i = 0; i < coins.length; i++) {
                dp[i][0] = 1;
            }

            for (int i = coins[0]; i <= amount; i++) {
                dp[0][i] += dp[0][i - coins[0]];
            }

            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j < coins[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // we can choose coins[i] or not
                        // if choose coins[i], then the way count is dp[i][j - coins[i]] (we need put coins[i] into backpack, so we need to remove some items)
                        // if not choose coins[i], then the way count is dp[i - 1][j]
                        // so total way count is dp[i][j - coins[i]] + dp[i - 1][j]
                        dp[i][j] = dp[i-1][j - coins[i]] + dp[i - 1][j];
                    }
                }
            }

            return dp[coins.length - 1][amount];
        }
    }
}
