package com.ben.tree;

import com.ben.common.TreeNode;

public class _0110_e_Balanced_Binary_Tree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = getHeight(root.left);
            if (leftHeight == -1) {
                return -1;
            }

            int rightHeight = getHeight(root.right);
            if (rightHeight == -1) {
                return -1;
            }

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
