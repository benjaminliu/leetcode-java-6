package com.ben.array.binarysearch;

public class _0153_Find_Minimum_in_Rotated_Sorted_Array {
    class Solution {
        public int findMin(int[] nums) {
            int left = -1;
            int right = nums.length - 1;

            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums[nums.length - 1]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            return nums[right];
        }
    }

    class Solution1 {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 2;

            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums[nums.length - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return nums[right];
        }
    }
}
