package com.ben.hashtable;

import java.util.HashSet;
import java.util.Set;

public class _0202_e_Happy_Number {
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();

            while (n != 1) {
                int tmp = n;
                int sum = 0;
                while (tmp > 0) {
                    int digit = tmp % 10;
                    tmp = tmp / 10;
                    sum += digit * digit;
                }
                if(set.contains(sum)){
                    return false;
                }
                set.add(sum);
                n = sum;
            }

            return true;
        }
    }
}
