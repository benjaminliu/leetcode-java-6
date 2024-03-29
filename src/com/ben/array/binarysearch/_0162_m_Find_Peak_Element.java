package com.ben.array.binarysearch;

public class _0162_m_Find_Peak_Element {
    class Solution {
        public int findPeakElement(int[] nums) {
            // the last cannot be peak, because peak need to bigger than left and right
            // [0, n-2]
            // (-1, n-1)
            int left = -1;
            int right = nums.length - 1;

            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            return right;
        }
    }
}
