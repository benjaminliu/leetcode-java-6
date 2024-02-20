package com.ben.greedy;

public class _0045_m_Jump_Game_II {
    class Solution {
        public int jump(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }

            int count = 0;
            int curCoverRange = 0;
            int maxCoverRange = 0;

            for (int i = 0; i < nums.length; i++) {
                maxCoverRange = Math.max(maxCoverRange, i + nums[i]);

                if (maxCoverRange >= nums.length - 1) {
                    count++;
                    break;
                }

                if (i == curCoverRange) {
                    //Need another step, because we reached the edge of previous step's cover range
                    count++;

                    curCoverRange = maxCoverRange;
                }
            }

            return count;
        }
    }
}
