package com.ben.greedy;

public class _0055_m_Jump_Game {

    public static void main(String[] args) {
//        int[] nums = new int[]{0};
        int[] nums = new int[]{0, 2, 3};

        System.out.println(new Solution().canJump(nums));
    }

    static
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int coverRage = 0;

            int last = nums.length - 1;
            for (int i = 0; i < last; i++) {
                if (coverRage < i) {
                    return false;
                }
                coverRage = Math.max(coverRage, i + nums[i]);
                if (coverRage >= last) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution1 {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
            int coverRange = 0;
            //在覆盖范围内更新最大的覆盖范围
            for (int i = 0; i <= coverRange; i++) {
                coverRange = Math.max(coverRange, i + nums[i]);
                if (coverRange >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
