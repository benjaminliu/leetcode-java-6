package com.ben.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_m_4Sum {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 4) {
                return res;
            }

            Arrays.sort(nums);

            for (int i = 0; i <= nums.length - 4; i++) {
                if (nums[i] > 0 && nums[i] > target) {
                    break;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j <= nums.length - 3; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int left = j + 1;
                    int right = nums.length - 1;

                    while (left < right) {
                        long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];

                        if (sum == target) {
                            res.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }

                            left++;
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
