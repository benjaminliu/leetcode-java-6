package com.ben.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_m_Permutations_II {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(nums);
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
                // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
                // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
                // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
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
