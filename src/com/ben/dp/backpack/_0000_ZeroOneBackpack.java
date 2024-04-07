package com.ben.dp.backpack;

public class _0000_ZeroOneBackpack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        int res = maxValue(weight, value, bagSize);
        System.out.println(res);
    }

    public static int maxValue(int[] weight, int[] value, int bagSize) {
        int n = weight.length;
        //[item][weight in the backpack] = until current item, what is the max value
        int[][] dp = new int[n][bagSize + 1];

        //put first item into backpack
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }

        //try putting other items into backpack one by one
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagSize; j++) {
                // current item cannot be put into backpack, because its weight is bigger than current capacity
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //Math.max(do not include current item,  include current item so need to remove other item with same weight)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }

        return dp[n - 1][bagSize];
    }
}
