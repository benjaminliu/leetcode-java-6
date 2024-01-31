package com.ben.tree;

import com.ben.common.TreeNode;

public class _0669_m_Trim_a_Binary_Search_Tree {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }

            TreeNode left = trimBST(root.left, low, high);
            TreeNode right = trimBST(root.right, low, high);

            if (root.val >= low && root.val <= high) {
                root.left = left;
                root.right = right;
                return root;
            }

            if (root.val < low) {
                return right;
            }

            return left;
        }
    }

    class Solution1 {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }

            if (root.val < low) {
                return trimBST(root.right, low, high);
            }

            if (root.val > high) {
                return trimBST(root.left, low, high);
            }

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
