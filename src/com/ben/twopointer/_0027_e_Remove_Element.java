package com.ben.twopointer;

public class _0027_e_Remove_Element {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0;

            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] == val) {
                    continue;
                }

                nums[slow] = nums[fast];
                slow++;
            }

            return slow;
        }
    }
}
