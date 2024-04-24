package com.ben.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0216_m_Combination_Sum_III {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(k, n, 1, new LinkedList<Integer>(), res);
            return res;
        }

        private void helper(int k, int n, int start, LinkedList<Integer> list, List<List<Integer>> res) {
            if (k == 0) {
                if (n == 0) {
                    res.add(new ArrayList<>(list));
                }

                return;
            }

            for (int i = start; i <= 9; i++) {
                if (i > n) {
                    return;
                }

                list.add(i);
                helper(k - 1, n - i, i + 1, list, res);
                list.removeLast();
            }
        }
    }
}
