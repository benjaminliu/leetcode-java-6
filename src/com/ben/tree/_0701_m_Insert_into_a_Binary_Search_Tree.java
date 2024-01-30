package com.ben.tree;

import com.ben.common.TreeNode;

public class _0701_m_Insert_into_a_Binary_Search_Tree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            helper(root, val);
            return root;
        }

        private void helper(TreeNode root, int val) {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    helper(root.left, val);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    helper(root.right, val);
                }
            }
        }
    }


    class Solution1 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
