package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0144_e_Binary_Tree_Preorder_Traversal {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);

            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }
}
