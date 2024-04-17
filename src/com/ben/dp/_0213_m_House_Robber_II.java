package com.ben.dp;

public class _0213_m_House_Robber_II {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            if (nums.length == 3) {
                return Math.max(nums[0], Math.max(nums[1], nums[2]));
            }

            int n = nums.length;
            int[] dp1 = new int[n];
            int[] dp2 = new int[n];

            helper(nums, dp1, 0, n - 2);
            helper(nums, dp2, 1, n - 1);

            return Math.max(dp1[n - 2], dp2[n - 1]);
        }

        private void helper(int[] nums, int[] dp, int start, int end) {
            dp[start] = nums[start];
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);

            for (int i = start + 2; i <= end; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
    }
}
