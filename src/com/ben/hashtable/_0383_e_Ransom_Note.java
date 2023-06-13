package com.ben.hashtable;

public class _0383_e_Ransom_Note {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] map = new int[26];

            for (Character c : magazine.toCharArray()) {
                int i = c2i(c);
                map[i]++;
            }

            for (Character c : ransomNote.toCharArray()) {
                int i = c2i(c);
                if (map[i] == 0) {
                    return false;
                }

                map[i]--;
            }

            return true;
        }

        private int c2i(char c) {
            return c - 'a';
        }
    }
}
