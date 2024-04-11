package com.ben.dp.knapsack.zeroOne;

import java.util.Arrays;

public class _0416_m_Partition_Equal_Subset_Sum {

    public static void main(String[] args) {
        int[] num = {1, 5, 11, 5};

        System.out.println(new Solution().canPartition(num));
    }

    static class Solution {
        /**
         * This is 0-1 backpack.
         * We can think the weight equals to the value.
         * The backpack size is sum / 2
         */
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();

            if (sum % 2 == 1) {
                return false;
            }

            int bagSize = sum / 2;
            int n = nums.length;

            //[item][weight in the backpack] = until current item, what is the max value
            int[][] dp = new int[n][bagSize + 1];

            for (int i = nums[0]; i <= bagSize; i++) {
                dp[0][i] = nums[0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= bagSize; j++) {
                    if (nums[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= bagSize; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return dp[n - 1][bagSize] == bagSize;
        }
    }
}
