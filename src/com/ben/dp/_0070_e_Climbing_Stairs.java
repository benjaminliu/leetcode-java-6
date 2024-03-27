package com.ben.dp;

public class _0070_e_Climbing_Stairs {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            int prePre = 1;
            int pre = 2;

            int cur = 0;
            for (int i = 3; i <= n; i++) {
                cur = pre + prePre;
                prePre = pre;
                pre = cur;
            }

            return cur;
        }
    }
}
