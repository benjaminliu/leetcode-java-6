package com.ben.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_m_Combination_Sum_II {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, target, 0, new ArrayList<Integer>(), res);

            return res;
        }

        private void helper(int[] candidates, int target, int start, ArrayList<Integer> list, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    return;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                list.add(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, list, res);
                list.removeLast();
            }
        }
    }
}
