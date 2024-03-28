package com.ben.dp;

public class _0746_e_Min_Cost_Climbing_Stairs {

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
//        int [] cost = new int[]{1,100,1,1,1,100,1,1,100,1};

        System.out.println(new Solution().minCostClimbingStairs(cost));
    }

    static
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int prePre = cost[0];
            int pre = cost[1];

            if (cost.length == 2) {
                return Math.min(pre, prePre);
            }

            int cur = 0;

            for (int i = 2; i < cost.length; i++) {
                cur = Math.min(pre, prePre) + cost[i];
                prePre = pre;
                pre = cur;
            }

            return Math.min(pre, prePre);
        }
    }
}
