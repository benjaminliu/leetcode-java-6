package com.ben.dp.backpack;

public class _0474_m_Ones_and_Zeroes {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];

            for (String str : strs) {
                int oneCount = 0;
                int zeroCount = 0;

                for (char c : str.toCharArray()) {
                    if (c == '0') {
                        zeroCount++;
                    } else {
                        oneCount++;
                    }
                }

                for (int i = m; i >= zeroCount; i--) {
                    for (int j = n; j >= oneCount; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                    }
                }
            }

            return dp[m][n];
        }
    }
}
