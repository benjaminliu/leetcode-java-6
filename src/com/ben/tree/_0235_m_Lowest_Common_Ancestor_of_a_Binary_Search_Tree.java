package com.ben.tree;

import com.ben.common.TreeNode;

public class _0235_m_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            if (root == p || root == q) {
                return root;
            }

            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }

            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }
    }
}
