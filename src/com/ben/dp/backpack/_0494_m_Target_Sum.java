package com.ben.dp.backpack;

import java.util.Arrays;

public class _0494_m_Target_Sum {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();

            if (Math.abs(target) > sum) {
                return 0;
            }

            // We separate the nums into two parts, left and right
            // left - right = target
            // right = sum - left
            // left - (sum - left) = target
            // 2 * left = target + sum
            // left = (target + sum) / 2
            // left should be a whole number, so (target + sum) % 2 should be 0
            if ((target + sum) % 2 == 1) {
                return 0;
            }

            // For the left, we can think it is a backpack,
            // so this changes to a backpack problem,
            // we have a backpack size of left
            // how many ways to fill the whole backpack

            int n = nums.length;
            int bagSize = (sum + target) / 2;

            //[item][weight in the backpack] = until current item, how many ways to fill [weight in the backpack]
            int[][] dp = new int[n][bagSize + 1];

            if (nums[0] <= bagSize) {
                dp[0][nums[0]] = 1;
            }

            int zeroCount = 0;

            // we can either add + or - before 0, that is 2.
            // so two zeros should be 2 power 2
            // three zeros should be 2 power 3
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    zeroCount++;
                }

                dp[i][0] = (int) Math.pow(2, zeroCount);
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= bagSize; j++) {
                    if (nums[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // we can choose num[i] or not
                        // if choose num[i], then the way count is dp[i - 1][j - nums[i]] (we need put num[i] into backpack, so we need to remove some items)
                        // if not choose num[i], then the way count is dp[i - 1][j]
                        // so total way count is dp[i - 1][j - nums[i]] + dp[i - 1][j]
                        dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j];
                    }
                }
            }

//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 0; j <= bagSize; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

            return dp[n - 1][bagSize];
        }
    }
}
