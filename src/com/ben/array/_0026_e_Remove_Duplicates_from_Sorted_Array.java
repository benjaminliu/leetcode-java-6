package com.ben.array;

public class _0026_e_Remove_Duplicates_from_Sorted_Array {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int move = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    move++;
                } else {
                    nums[i - move] = nums[i];
                }
            }

            return nums.length - move;
        }
    }
}
