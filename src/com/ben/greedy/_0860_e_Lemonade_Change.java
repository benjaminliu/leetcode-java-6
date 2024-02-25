package com.ben.greedy;

public class _0860_e_Lemonade_Change {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 20};

        System.out.println(new Solution().lemonadeChange(bills));
    }

    static
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int fiveCount = 0;
            int tenCount = 0;

            for (int b : bills) {
                if (b == 20) {
                    if (!has15(tenCount, fiveCount)) {
                        return false;
                    }

                    if (tenCount > 0) {
                        tenCount--;
                        fiveCount--;
                    } else {
                        fiveCount -= 3;
                    }
                } else if (b == 10) {
                    if (fiveCount == 0) {
                        return false;
                    }
                    fiveCount--;
                    tenCount++;
                } else {
                    fiveCount++;
                }
            }

            return true;
        }

        private boolean has15(int tenCount, int fiveCount) {
            if (tenCount > 0 && fiveCount > 0) {
                return true;
            }

            if (fiveCount > 2) {
                return true;
            }

            return false;
        }
    }
}
