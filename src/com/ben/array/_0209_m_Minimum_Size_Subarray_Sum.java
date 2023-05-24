package com.ben.array;

public class _0209_m_Minimum_Size_Subarray_Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;

        System.out.println(new Solution().minSubArrayLen(target, nums));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;

            int sum = 0;
            int minLen = Integer.MAX_VALUE;
            int last = nums.length - 1;

            while (right <= last) {
                sum += nums[right];
                if (sum >= target) {
                    int len = right - left + 1;
                    minLen = Math.min(minLen, len);
                    sum -= nums[left];
                    left++;
                    sum -= nums[right]; //next loop will add again
                } else {
                    right++;
                }
            }

            if (minLen > nums.length) {
                return 0;
            }

            return minLen;
        }
    }

    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int sum = 0;
            int minLen = Integer.MAX_VALUE;

            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];

                while (sum >= target) {
                    int len = right - left + 1;
                    minLen = Math.min(minLen, len);
                    sum -= nums[left++];
                }
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}
