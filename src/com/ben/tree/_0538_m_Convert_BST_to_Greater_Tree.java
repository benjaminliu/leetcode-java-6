package com.ben.tree;

import com.ben.common.TreeNode;

public class _0538_m_Convert_BST_to_Greater_Tree {
    class Solution {

        private int sum;
        public TreeNode convertBST(TreeNode root) {
            if(root == null){
                return null;
            }

            sum = 0;

            helper(root);

            return root;
        }

        private void helper(TreeNode root) {
            if(root == null){
                return;
            }

            helper(root.right);

            sum += root.val;
            root.val = sum;

            helper(root.left);
        }
    }
}
