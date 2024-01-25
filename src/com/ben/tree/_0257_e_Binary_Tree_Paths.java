package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0257_e_Binary_Tree_Paths {

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            helper(root, "", res);

            return res;
        }

        private void helper(TreeNode root, String str, List<String> res) {
            if (!str.equals("")) {
                str += "->" + root.val;
            } else {
                str = "" + root.val;
            }

            if (root.left == null && root.right == null) {
                res.add(str);
                return;
            }

            if (root.left != null) {
                helper(root.left, str, res);
            }

            if (root.right != null) {
                helper(root.right, str, res);
            }
        }
    }
}
