package com.ben.tree;

import com.ben.common.TreeNode;

public class _0530_e_Minimum_Absolute_Difference_in_BST {

    class Solution {

        private TreeNode pre;

        private int minDiff;

        public int getMinimumDifference(TreeNode root) {
            pre = null;
            minDiff = Integer.MAX_VALUE;

            helper(root);
            return minDiff;
        }

        private void helper(TreeNode root) {
            if (root == null) {
                return;
            }

            helper(root.left);

            if (pre != null) {
                int diff = root.val - pre.val;
                minDiff = Math.min(minDiff, diff);
            }

            pre = root;

            helper(root.right);
        }
    }
}
