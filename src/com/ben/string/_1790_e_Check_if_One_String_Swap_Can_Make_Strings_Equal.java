package com.ben.string;

public class _1790_e_Check_if_One_String_Swap_Can_Make_Strings_Equal {

    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int firstIdx = -1;
            int secondIdx = -1;
            int diffCount = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCount++;
                    if (diffCount > 2) {
                        return false;
                    }

                    if (diffCount == 1) {
                        firstIdx = i;
                    } else {
                        secondIdx = i;
                    }
                }
            }

            if (diffCount == 0) {
                return true;
            }

            if (diffCount != 2) {
                return false;
            }

            if (s1.charAt(firstIdx) != s2.charAt(secondIdx)) {
                return false;
            }

            if (s1.charAt(secondIdx) != s2.charAt(firstIdx)) {
                return false;
            }

            return true;
        }
    }
}
