package com.ben.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _0242_e_Valid_Anagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }

            for (char c : t.toCharArray()) {
                int count = map.getOrDefault(c, 0);
                if (count == 0) {
                    return false;
                }

                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }

            return map.size() == 0;
        }
    }
}
