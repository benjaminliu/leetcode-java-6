package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _0501_e_Find_Mode_in_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.left.left = new TreeNode(0);


        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println(new Solution().findMode(root));
    }

    static class Solution {

        private List<Integer> list;
        private int maxCount;
        private int count;
        private TreeNode pre;

        public int[] findMode(TreeNode root) {
            list = new ArrayList<>();
            maxCount = 0;
            count = 0;
            pre = null;

            helper(root);

            //process again, in case the last node is the same as pre
            process();

            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void helper(TreeNode root) {
            if (root == null) {
                return;
            }

            helper(root.left);

            if (pre == null) {
                count = 1;
                pre = root;
            } else if (pre.val == root.val) {
                count++;
            } else {
                process();

                pre = root;
                count = 1;
            }

            helper(root.right);
        }

        private void process() {
            if (count > maxCount) {
                list.clear();
                list.add(pre.val);
                maxCount = count;
            } else if (count == maxCount) {
                list.add(pre.val);
            } else {
                //Less than maxCount, ignore it
            }
        }
    }
}
