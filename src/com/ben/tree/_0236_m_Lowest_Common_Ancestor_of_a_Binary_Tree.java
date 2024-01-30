package com.ben.tree;

import com.ben.common.TreeNode;

public class _0236_m_Lowest_Common_Ancestor_of_a_Binary_Tree {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            if (root == p) {
                return p;
            }

            if (root == q) {
                return q;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            //left is null, so none of p and q are in left branch,
            //if right is null, none of p and q are in left branch, return null
            //if right is not null, then one or both of p and q is in right branch
            if (left == null) {
                return right;
            }

            if (right == null) {
                return left;
            }

            //Both left and right are not null, means one is in left branch , the other one is in right branch,
            //so root it the lowest common ancestor
            return root;
        }
    }
}
