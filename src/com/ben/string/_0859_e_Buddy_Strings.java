package com.ben.string;

public class _0859_e_Buddy_Strings {

    class Solution {
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }

            int firstIdx = -1;
            int secondIdx = -1;
            int diffCount = 0;

            //Check if there is any duplicated char
            int[] map = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map[c - 'a']++;

                if (c != goal.charAt(i)) {
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
                //Two string are the same, and there is no duplicate char in s, so any switch will result a different string
                for (int i : map) {
                    if (i > 1) {
                        return true;
                    }
                }
                return false;
            }

            if (diffCount != 2) {
                return false;
            }

            if (s.charAt(firstIdx) != goal.charAt(secondIdx)) {
                return false;
            }

            if (s.charAt(secondIdx) != goal.charAt(firstIdx)) {
                return false;
            }

            return true;
        }
    }
}
