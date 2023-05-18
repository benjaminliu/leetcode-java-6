package com.ben.array;

public class _0027_e_Remove_Element {

    public static void main(String[] args) {

        int[] nums = new int[]{
                0, 1, 2, 2, 3, 0, 4, 2
        };
        int val = 2;
        System.out.println(new Solution().removeElement(nums, val));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int move = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    move++;
                } else {
                    nums[i - move] = nums[i];
                }
            }

            return nums.length - move;
        }
    }
}
