package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0106_m_ConstructBinary_Tree_from_Inorder_and_Postorder_Traversal {

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder.length == 0) {
                return null;
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(postorder, 0, postorder.length - 1, 0, map);
        }

        private TreeNode helper(int[] postOrder, int postOrderStart, int postOrderEnd, int inorderStart, Map<Integer, Integer> map) {
            if (postOrderStart > postOrderEnd) {
                return null;
            }

            int cur = postOrder[postOrderEnd];
            TreeNode root = new TreeNode(cur);

            if (postOrderStart == postOrderEnd) {
                //Leaf, not child, one 1 node
                return root;
            }

            int idx = map.get(cur);
            int lastDescendentIdx = idx - 1;

            int idxDiff = lastDescendentIdx - inorderStart;

            root.left = helper(postOrder, postOrderStart, postOrderStart + idxDiff, inorderStart, map);
            root.right = helper(postOrder, postOrderStart + idxDiff + 1, postOrderEnd - 1, idx + 1, map);
            return root;
        }
    }
}
