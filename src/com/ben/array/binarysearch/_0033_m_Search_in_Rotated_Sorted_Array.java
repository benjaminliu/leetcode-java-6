package com.ben.array.binarysearch;

public class _0033_m_Search_in_Rotated_Sorted_Array {
    class Solution {


        public int search(int[] nums, int target) {
            int left = -1;
            int right = nums.length;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (isBlue(nums, target, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            if (right == nums.length || nums[right] != target) {
                return -1;
            }

            return right;
        }

        /**
         * blue means the target node is on the left side
         */
        private boolean isBlue(int[] nums, int target, int idx) {
            int end = nums[nums.length - 1];
            if (nums[idx] > end) {
                return target > end && nums[idx] >= target;
            }
            return target > end || nums[idx] >= target;
        }
    }
}
