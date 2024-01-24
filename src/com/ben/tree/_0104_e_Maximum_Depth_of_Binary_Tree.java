package com.ben.tree;

import com.ben.common.TreeNode;

public class _0104_e_Maximum_Depth_of_Binary_Tree {
    class Solution {

        public int maxDepth(TreeNode root) {
            return maxDepth(root, 0);
        }

        private int maxDepth(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }

            depth++;
            int left = maxDepth(root.left, depth);
            int right = maxDepth(root.right, depth);

            return Math.max(left, right);
        }
    }
}
