package com.ben.backtracking;

import java.util.*;

public class _0491_m_Non_decreasing_Subsequences {
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, 0, new LinkedList<>(), res);
            return res;
        }

        private void helper(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> res) {

            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }

            Set<Integer> set = new HashSet<>();

            for (int i = start; i < nums.length; i++) {
                if (list.size() > 0 && nums[i] < list.get(list.size() - 1)) {
                    continue;
                }

                //check duplication
                if (!set.add(nums[i])) {
                    continue;
                }

                list.add(nums[i]);
                helper(nums, i + 1, list, res);
                list.removeLast();
            }
        }
    }
}
