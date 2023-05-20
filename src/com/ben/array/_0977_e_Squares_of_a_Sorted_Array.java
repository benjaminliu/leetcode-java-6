package com.ben.array;

public class _0977_e_Squares_of_a_Sorted_Array {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int lo = 0;
            int hi = nums.length - 1;

            int[] res = new int[nums.length];

            int idx = hi;

            while (lo < hi) {
                int l = nums[lo] * nums[lo];
                int r = nums[hi] * nums[hi];

                if (l > r) {
                    lo++;
                    res[idx--] = l;
                } else {
                    hi--;
                    res[idx--] = r;
                }
            }

            res[0] = nums[lo] * nums[lo];

            return res;
        }
    }
}
