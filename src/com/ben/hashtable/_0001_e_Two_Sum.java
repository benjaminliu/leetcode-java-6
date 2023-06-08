package com.ben.hashtable;

import com.ben.common.PrintUtil;

import java.util.HashMap;
import java.util.Map;

public class _0001_e_Two_Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};

        int target = 9;

        PrintUtil.printArray(new Solution().twoSum(nums, target));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int num1 = nums[i];
                Integer idx = map.get(num1);
                if (idx != null) {
                    return new int[]{i, idx};
                }
                map.put(target - num1, i);
            }

            return null;
        }
    }
}
