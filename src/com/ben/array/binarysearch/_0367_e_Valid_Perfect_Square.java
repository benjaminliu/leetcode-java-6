package com.ben.array.binarysearch;

public class _0367_e_Valid_Perfect_Square {
    class Solution {
        public boolean isPerfectSquare(int num) {
            long target = num;
            long lo = 0;
            long hi = num;

            while (lo <= hi) {
                long mid = (lo + hi) / 2;

                long sqr = mid * mid;

                if (sqr == target) {
                    return true;
                }

                if (sqr < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return false;
        }
    }
}
