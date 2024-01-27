package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0105_m_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(preorder, 0, preorder.length - 1, 0, map);
        }

        private TreeNode helper(int[] preorder, int preorderStart, int preorderEnd, int inorderStart, Map<Integer, Integer> map) {
            if (preorderStart > preorderEnd) {
                return null;
            }

            int cur = preorder[preorderStart];
            TreeNode root = new TreeNode(cur);

            if (preorderStart == preorderEnd) {
                //Only 1 node, leaf, no children
                return root;
            }

            int curIdx = map.get(cur);
            int lastNodeOfLeftSubtreeIdx = curIdx - 1;

            int indexDiff = lastNodeOfLeftSubtreeIdx - inorderStart;

            root.left = helper(preorder, preorderStart + 1, preorderStart + 1 + indexDiff, inorderStart, map);
            root.right = helper(preorder, preorderStart + 1 + indexDiff + 1, preorderEnd, curIdx + 1, map);

            return root;
        }
    }
}
