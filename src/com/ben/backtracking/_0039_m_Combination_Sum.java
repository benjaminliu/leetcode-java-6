package com.ben.backtracking;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _0039_m_Combination_Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        PrintUtil.printListOfList(new Solution().combinationSum(nums, 7));
    }

    static
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, target, 0, new LinkedList<Integer>(), res);
            return res;
        }

        private void helper(int[] candidates, int target, int start, LinkedList<Integer> list, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    return;
                }

                list.add(candidates[i]);
                helper(candidates, target - candidates[i], i, list, res);
                list.removeLast();
            }
        }
    }
}
