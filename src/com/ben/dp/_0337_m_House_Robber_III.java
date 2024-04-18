package com.ben.dp;

import com.ben.common.TreeNode;

public class _0337_m_House_Robber_III {
    class Solution {
        public int rob(TreeNode root) {
            int[] res = helper(root);

            return Math.max(res[0], res[1]);
        }

        private int[] helper(TreeNode root) {
            int[] res = new int[2];

            if (root == null) {
                return res;
            }

            int[] left = helper(root.left);
            int[] right = helper(root.right);

            // 不偷当前：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            // 偷当前：左孩子不偷 + 右孩子不偷 + 当前节点偷
            res[1] = root.val + left[0] + right[0];

            return res;
        }
    }
}
