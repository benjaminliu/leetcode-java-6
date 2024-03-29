package com.ben.greedy;

public class _0376_m_Wiggle_Subsequence {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }

            int curDiff = 0;
            int preDiff = 0;

            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                curDiff = nums[i] - nums[i - 1];

                if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                    count++;
                    preDiff = curDiff;
                }
            }

            return count;
        }
    }
}
