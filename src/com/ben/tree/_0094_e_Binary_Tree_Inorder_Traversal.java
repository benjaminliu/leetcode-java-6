package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0094_e_Binary_Tree_Inorder_Traversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
