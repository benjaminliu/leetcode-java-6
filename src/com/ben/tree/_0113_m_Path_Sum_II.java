package com.ben.tree;

import com.ben.common.PrintUtil;
import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0113_m_Path_Sum_II {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution s = new Solution();

        PrintUtil.printListOfList(s.pathSum(root, 22));
    }

    static
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            helper(root, targetSum, new ArrayList<>(), res);

            return res;
        }

        private void helper(TreeNode root, int targetSum, ArrayList<Integer> list, List<List<Integer>> res) {
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    list.add(root.val);
                    res.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                }

                return;
            }

            targetSum -= root.val;
            list.add(root.val);

            if (root.left != null) {
                helper(root.left, targetSum, list, res);
            }

            if (root.right != null) {
                helper(root.right, targetSum, list, res);
            }

            list.remove(list.size() - 1);
        }
    }
}
