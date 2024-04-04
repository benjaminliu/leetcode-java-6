package com.ben.dp;

public class _0096_m_Unique_Binary_Search_Trees {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(new Solution().numTrees(n));
    }

    static
    class Solution {
        public int numTrees(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    //dp[j - 1] left subtree's node count
                    //dp[i - j] right subtree's node oount
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }

            return dp[n];
        }
    }
}
