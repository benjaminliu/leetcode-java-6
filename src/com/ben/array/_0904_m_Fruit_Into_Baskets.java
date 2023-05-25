package com.ben.array;

import java.util.*;

public class _0904_m_Fruit_Into_Baskets {
    public static void main(String[] args) {
        int[] fruits = new int[]{1, 2, 3, 2, 2};

        System.out.println(new Solution().totalFruit(fruits));
    }

    static class Solution {
        public int totalFruit(int[] fruits) {
            if (fruits.length < 3) {
                return fruits.length;
            }

            int max = 0;
            int left = 0;

            Map<Integer, Integer> map = new HashMap<>();
            for (int right = 0; right < fruits.length; right++) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

                while (map.size() > 2) {
                    int count = map.get(fruits[left]);
                    if (count == 1) {
                        map.remove(fruits[left]);
                    } else {
                        map.put(fruits[left], count - 1);
                    }
                    left++;
                }
                max = Math.max(max, right - left + 1);
            }

            return max;
        }
    }
}
