package com.ben.stackqueue;

import java.util.Stack;

public class _0020_e_Valid_Parentheses {

    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) {
                return false;
            }

            char[] chars = s.toCharArray();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char d = stack.pop();
                    if (c != d) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
