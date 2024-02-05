package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0046_m_Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];

            helper(nums, used, new ArrayList<>(), res);
            return res;
        }

        private void helper(int[] nums, boolean[] used, ArrayList<Integer> list, List<List<Integer>> res) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                list.add(nums[i]);
                used[i] = true;
                helper(nums, used, list, res);
                list.removeLast();
                used[i] = false;
            }
        }
    }
}
