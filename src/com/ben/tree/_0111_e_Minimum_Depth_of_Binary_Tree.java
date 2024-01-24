package com.ben.tree;

import com.ben.common.TreeNode;

public class _0111_e_Minimum_Depth_of_Binary_Tree {

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return minDepth(root, 0);
        }

        private int minDepth(TreeNode root, int depth) {
            if (root == null) {
                return -1;
            }
            depth++;
            if (root.left == null && root.right == null) {
                return depth;
            }

            int left = minDepth(root.left, depth);
            int right = minDepth(root.right, depth);

            if (left == -1) {
                return right;
            }

            if (right == -1) {
                return left;
            }

            return Math.min(left, right);
        }
    }
}
