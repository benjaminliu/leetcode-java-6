package com.ben.tree;

import com.ben.common.TreeNode;

public class _0222_e_Count_Complete_Tree_Nodes {
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            TreeNode left = root.left;
            int leftDepth = 0;
            while (left != null) {
                left = left.left;
                leftDepth++;
            }

            TreeNode right = root.right;
            int rightDepth = 0;
            while (right != null) {
                right = right.right;
                rightDepth++;
            }

            if (leftDepth == rightDepth) {
                //Perfect binary tree's node count = (2 ^ k) - 1
                return (2 << leftDepth) - 1;
            }

            //Not perfect binary tree, count its left subtree and right subtree and add itself
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
