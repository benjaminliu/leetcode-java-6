package com.ben.tree;

import com.ben.common.TreeNode;

public class _0450_m_Delete_Node_in_a_BST {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                //current node is the target node to delete

                //Current node has no child, we just need to set current node to null to delete it (no need replacing)
                //This is included in below code (current node only has 1 child), leave it here to make the logic more clear
                if (root.left == null && root.right == null) {
                    return null;
                }

                //Current node only has 1 child, just replace its child to current node
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                //Current node has 2 children,
                //Find the min node of its right branch, remove it, and then replace current node

                TreeNode minNode = root.right;
                TreeNode parent = null;
                while (minNode.left != null) {
                    parent = minNode;
                    minNode = minNode.left;
                }

                if (parent == null) {
                    //Current node's right child does not have left child (is the minNode)
                    root.right = minNode.right;
                } else {
                    //Current node's right child has left child (is not the minNode)
                    parent.left = minNode.right;
                }

                //Replacing current node with minNode
                minNode.left = root.left;
                minNode.right = root.right;

                return minNode;
            }

            return root;
        }
    }
}
