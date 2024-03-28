package com.ben.array.binarysearch;

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


    class Solution1 {
        /**
         * - 有序数组中二分查找的四种类型（下面的转换仅适用于数组中都是整数）
         *     1. 第一个大于等于x的下标： low_bound(x)
         *     2. 第一个大于x的下标：可以转换为`第一个大于等于 x+1 的下标` ，low_bound(x+1)
         *     3. 最后一个一个小于x的下标：可以转换为`第一个大于等于 x 的下标` 的`左边位置`, low_bound(x) - 1;
         *     4. 最后一个小于等于x的下标：可以转换为`第一个大于等于 x+1 的下标` 的 `左边位置`, low_bound(x+1) - 1;
         */
        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound(nums, target);
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }
            int end = lowerBound(nums, target + 1) - 1;

            return new int[]{start, end};
        }

        // [left, right]
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        // [left, right)
        private int lowerBound2(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid; // [left, mid)
                }
            }
            return left;
        }

        // (left, right)
        private int lowerBound3(int[] nums, int target) {
            int left = -1;
            int right = nums.length;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            return right;
        }
    }
}
