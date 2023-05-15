package com.ben.array;

public class _0704_e_Binary_Search {

    class Solution {
        public int search(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            if (nums[lo] > target || nums[hi] < target) {
                return -1;
            }

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return -1;
        }
    }
}
