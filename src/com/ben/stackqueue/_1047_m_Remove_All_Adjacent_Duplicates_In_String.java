package com.ben.stackqueue;

import java.util.Stack;

public class _1047_m_Remove_All_Adjacent_Duplicates_In_String {
    class Solution {
        public String removeDuplicates(String s) {
            char[] chars = s.toCharArray();

            Stack<Character> stack = new Stack<>();
            for(char c : chars){
                if(!stack.isEmpty()){
                    if(stack.peek()  == c){
                        stack.pop();
                        continue;
                    }
                }

                stack.push(c);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }

            return sb.reverse().toString();
        }
    }
}
