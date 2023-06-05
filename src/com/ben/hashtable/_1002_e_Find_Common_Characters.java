package com.ben.hashtable;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1002_e_Find_Common_Characters {

    public static void main(String[] args) {
        String[] words = new String[]{"bella", "label", "roller"};

        PrintUtil.printList(new Solution().commonChars(words));
    }

    static class Solution {
        public List<String> commonChars(String[] words) {
            int[] map = new int[26];

            for (char c : words[0].toCharArray()) {
                map[c2i(c)]++;
            }


            for (int i = 1; i < words.length; i++) {
                String word = words[i];
                int[] newMap = new int[26];

                for (char c : word.toCharArray()) {
                    newMap[c2i(c)]++;
                }

                for (int j = 0; j < map.length; j++) {
                    if (map[j] > newMap[j]) {
                        map[j] = newMap[j];
                    }
                }
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                while (map[i] > 0) {
                    res.add(String.valueOf(i2c(i)));
                    map[i]--;
                }
            }

            return res;
        }

        private int c2i(char c) {
            return c - 'a';
        }

        private char i2c(int i) {
            return (char) (i + 'a');
        }
    }


}
