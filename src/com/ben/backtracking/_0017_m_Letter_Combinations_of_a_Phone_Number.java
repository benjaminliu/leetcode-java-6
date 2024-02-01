package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _0017_m_Letter_Combinations_of_a_Phone_Number {


    class Solution {

        private Map<Character, List<Character>> map = Map.of('2', List.of('a', 'b', 'c'), '3', List.of('d', 'e', 'f'), '4', List.of('g', 'h', 'i'), '5', List.of('j', 'k', 'l'), '6', List.of('m', 'n', 'o'), '7', List.of('p', 'q', 'r', 's'), '8', List.of('t', 'u', 'v'), '9', List.of('w', 'x', 'y', 'z'));

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            helper(digits, 0, new StringBuilder(), res);
            return res;
        }

        private void helper(String digits, int start, StringBuilder sb, List<String> res) {
            if (start == digits.length()) {
                res.add(sb.toString());
                return;
            }

            List<Character> chars = map.get(digits.charAt(start));
            for (Character c : chars) {
                sb.append(c);
                helper(digits, start + 1, sb, res);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
