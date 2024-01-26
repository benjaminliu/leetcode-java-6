package com.ben.tree;

import com.ben.common.TreeNode;

public class _0404_e_Sum_of_Left_Leaves {

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {

            return helper(root, false);
        }

        private int helper(TreeNode root, boolean isLeftSubTree) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                //is leaf
                if (isLeftSubTree) {
                    return root.val;
                }
                return 0;
            }

            int res = helper(root.left, true);
            res += helper(root.right, false);

            return res;
        }
    }
}
