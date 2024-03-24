package com.ben.greedy;

import com.ben.common.TreeNode;

public class _0968_h_Binary_Tree_Cameras {
    class Solution {
        private int res;

        public int minCameraCover(TreeNode root) {
            res = 0;

            if (helper(root) == 0) {
                res++;
            }

            return res;
        }

        //return 0 means current node is not monitored by a camara, so we should add a camara in its parent
        //return 1 means current node is monitored by a camara, but the camara is not in current node
        //return 2 means there is a camara in current node.
        private int helper(TreeNode root) {
            if (root == null) {
                return 1;
            }

            int l = helper(root.left);
            int r = helper(root.right);

            if (l == 0 || r == 0) {
                res++;
                return 2;
            }

            if (l == 1 && r == 1) {
                return 0;
            }

            return 1;
        }
    }
}
