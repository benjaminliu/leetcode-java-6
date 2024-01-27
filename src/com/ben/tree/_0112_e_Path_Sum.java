package com.ben.tree;

import com.ben.common.TreeNode;

public class _0112_e_Path_Sum {

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    return true;
                }
                return false;
            }

            targetSum -= root.val;

            boolean left = hasPathSum(root.left, targetSum);
            if (left == true) {
                return true;
            }

            boolean right = hasPathSum(root.right, targetSum);
            if (right == true) {
                return true;
            }

            return false;
        }

    }
}
