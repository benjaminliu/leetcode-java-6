package com.ben.greedy;

import java.util.Arrays;

public class _0135_h_Candy {
    class Solution {
        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] candys = new int[len];
            candys[0] = 1;
            for (int i = 1; i < len; i++) {
                candys[i] = ratings[i] > ratings[i - 1] ? candys[i - 1] + 1 : 1;
            }

            for (int i = len - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candys[i] = Math.max(candys[i], candys[i + 1] + 1);
                }
            }

            return Arrays.stream(candys).sum();
        }
    }
}
