package com.ben.greedy;

import java.util.Arrays;

public class _1005_e_Maximize_Sum_Of_Array_After_K_Negations {
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 && k > 0) {
                    nums[i] *= -1;
                    k--;
                } else {
                    break;
                }
            }

            int res = 0, min = Integer.MAX_VALUE;
            for (int a : nums) {
                res += a;
                min = Math.min(min, a);
            }

            //If k is bigger than 0, means all the nums are positive
            return res - (k % 2) * min * 2;
        }
    }
}
