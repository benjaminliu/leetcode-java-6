package com.ben.greedy;

import java.util.Arrays;

public class _0455_e_Assign_Cookies {
    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};

        System.out.println(new Solution().findContentChildren(g, s));
    }

    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int res = 0;
            int idx = 0;

            for (int i = 0; i < g.length; i++) {
                while (idx < s.length) {
                    if (g[i] > s[idx]) {
                        idx++;
                    } else {
                        res++;
                        idx++;
                        break;
                    }
                }
            }

            return res;
        }
    }
}
