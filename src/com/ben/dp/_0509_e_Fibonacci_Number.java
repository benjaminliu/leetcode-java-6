package com.ben.dp;

public class _0509_e_Fibonacci_Number {
    class Solution {
        public int fib(int n) {
            int prePre = 0;
            if (n == 0) {
                return prePre;
            }
            int pre = 1;
            if (n == 1) {
                return pre;
            }

            int cur = pre + prePre;
            for (int i = 2; i <= n; i++) {
                cur = pre + prePre;
                prePre = pre;
                pre = cur;
            }

            return cur;
        }
    }
}
