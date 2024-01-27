package com.ben.tree;

import com.ben.common.TreeNode;

public class _0654_m_Maximum_Binary_Tree {

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            if (start == end) {
                return new TreeNode(nums[start]);
            }

            int maxIdx = start;
            int max = nums[start];
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIdx = i;
                }
            }

            TreeNode root = new TreeNode(max);

            root.left = helper(nums, start, maxIdx - 1);
            root.right = helper(nums, maxIdx + 1, end);

            return root;
        }
    }
}
