package com.ben.array;

import com.ben.common.PrintUtil;

public class _0034_m_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        int target = 2;
        PrintUtil.printArray(new Solution().searchRange(nums, target));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
                return new int[]{-1, -1};
            }

            int first = findFirst(nums, target);
            if (first == -1) {
                return new int[]{-1, -1};
            }

            int last = findLast(nums, target);

            return new int[]{first, last};
        }

        private int findFirst(int[] nums, int target) {

            int lo = 0;
            int hi = nums.length - 1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    if (mid == 0) {
                        return 0;
                    }

                    if (nums[mid - 1] != target) {
                        return mid;
                    }

                    hi = mid - 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return -1;
        }

        private int findLast(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            int last = hi;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    if (mid == last) {
                        return last;
                    }

                    if (nums[mid + 1] != target) {
                        return mid;
                    }

                    lo = mid + 1;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return -1;
        }
    }
}
