package com.ben.array.binarysearch;

public class _0035_e_Search_Insert_Position {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            if (nums[lo] > target) {
                return 0;
            }

            if (nums[hi] < target) {
                return nums.length;
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

            return lo;
        }
    }
}
