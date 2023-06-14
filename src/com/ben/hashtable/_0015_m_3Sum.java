package com.ben.hashtable;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_m_3Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, -1, 0};

        PrintUtil.printListOfList(new Solution().threeSum(nums));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0, last = nums.length - 3; i <= last; i++) {
                if (nums[i] > 0) {
                    break;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(List.of(nums[i], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return res;
        }
    }
}
