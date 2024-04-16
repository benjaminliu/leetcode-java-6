package com.ben.dp;

public class _0198_m_House_Robber {

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        System.out.println(new Solution().rob(nums));
    }
    static
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }


            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }

            return dp[nums.length - 1];
        }
    }
}
