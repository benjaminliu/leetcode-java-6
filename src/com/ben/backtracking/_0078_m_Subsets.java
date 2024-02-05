package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0078_m_Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, 0, new ArrayList<>(), res);
            return res;
        }

        private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
            res.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                helper(nums, i + 1, list, res);
                list.removeLast();
            }
        }
    }
}
