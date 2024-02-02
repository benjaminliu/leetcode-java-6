package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0131_m_Palindrome_Partitioning {

    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();

            helper(s, 0, new ArrayList<String>(), res);

            return res;
        }

        private void helper(String s, int start, ArrayList<String> list, List<List<String>> res) {
            if (start >= s.length()) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }

                String str = s.substring(start, i + 1);
                list.add(str);
                helper(s, i + 1, list, res);
                list.removeLast();
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }

                start++;
                end--;
            }
            return true;
        }
    }
}
