package com.ben.dp;

public class _0343_m_Integer_Break {
    class Solution {
        public int integerBreak(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }

            if (n == 4) {
                return 4;
            }

            int multi = 1;

            while (n > 4) {
                multi *= 3;
                n -= 3;
            }

            return multi * n;
        }
    }

    class Solution1 {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                for (int j = 1, end = i / 2; j <= end; j++) {
                    // i可以差分为i-j和j。由于需要最大值，故需要通过j遍历所有存在的值，取其中最大的值作为当前i的最大值，在求最大值的时候，一个是j与i-j相乘，一个是j与dp[i-j].
                    dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
                }
            }

            return dp[n];
        }
    }
}
