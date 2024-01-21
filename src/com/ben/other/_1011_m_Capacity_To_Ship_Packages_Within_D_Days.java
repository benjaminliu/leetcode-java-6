package com.ben.other;

public class _1011_m_Capacity_To_Ship_Packages_Within_D_Days {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int max = 0;
            int sum = 0;

            for (int w : weights) {
                max = Math.max(max, w);
                sum += w;
            }

            //Max is the min possible conveyor max weight
            //Sum is the max possible conveyor max weight
            int left = max;
            int right = sum;

            while (left < right) {
                int mid = (left + right) / 2;
                int needDay = 1;
                int oneDayWeight = 0;

                for (int w : weights) {
                    oneDayWeight += w;
                    if (oneDayWeight > mid) {
                        //wight bigger then conveyor max weight, so we need another day
                        needDay++;
                        //A new day, reset, but we need to add current package into next day
                        oneDayWeight = w;
                    }
                }
                if (needDay > days) {
                    //the conveyor max weight is not enough, we need more
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
