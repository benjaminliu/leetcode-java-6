package com.ben.tree;

import com.ben.common.TreeNode;

public class _0098_m_Validate_Binary_Search_Tree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);

        System.out.println(new Solution().isValidBST(root));
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long minValue, long maxValue) {
            if (root == null) {
                return true;
            }

            if (root.val <= minValue || root.val >= maxValue) {
                return false;
            }

            if (!helper(root.left, minValue, root.val)) {
                return false;
            }

            if (!helper(root.right, root.val, maxValue)) {
                return false;
            }

            return true;
        }
    }
}
