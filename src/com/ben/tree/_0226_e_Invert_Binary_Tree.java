package com.ben.tree;

import com.ben.common.TreeNode;

public class _0226_e_Invert_Binary_Tree {

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
