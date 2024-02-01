package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0077_m_Combinations {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            helper(n, k, 1, new ArrayList<Integer>(), res);

            return res;
        }

        private void helper(int n, int k, int start, ArrayList<Integer> list, List<List<Integer>> res) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = start; i <= n; i++) {
                list.add(i);
                helper(n, k, i + 1, list, res);
                list.removeLast();
            }
        }
    }

    class Solution1 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            helper(n, k, 1, new ArrayList<Integer>(), res);

            return res;
        }

        private void helper(int n, int k, int start, ArrayList<Integer> list, List<List<Integer>> res) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }

            int left = k - list.size();
            int end = n - left + 1;
            for (int i = start; i <= end; i++) {
                list.add(i);
                helper(n, k, i + 1, list, res);
                list.removeLast();
            }
        }
    }
}
