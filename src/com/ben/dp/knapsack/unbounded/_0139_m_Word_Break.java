package com.ben.dp.knapsack.unbounded;

import java.util.List;

public class _0139_m_Word_Break {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (String word : wordDict) {
                    int len = word.length();
                    if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
