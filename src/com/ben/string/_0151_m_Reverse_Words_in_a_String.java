package com.ben.string;

import java.util.Deque;
import java.util.LinkedList;

public class _0151_m_Reverse_Words_in_a_String {

    public static void main(String[] args) {
        String s = "   a good   example   ";

        System.out.println(new Solution().reverseWords(s));
    }

    static
    class Solution {
        public String reverseWords(String s) {
            int start = 0;
            int end = s.length() - 1;

            //trim start
            while (start < end) {
                if (s.charAt(start) == ' ') {
                    start++;
                } else {
                    break;
                }
            }

            //trim end
            while (start < end) {
                if (s.charAt(end) == ' ') {
                    end--;
                } else {
                    break;
                }
            }

            Deque<Character> deque = new LinkedList<>();

            while (start <= end) {
                char cur = s.charAt(end);
                if (cur == ' ' && deque.peekLast() == ' ') {
                } else {
                    deque.addLast(cur);
                }
                end--;
            }

            StringBuilder sb = new StringBuilder();

            Deque<Character> stack = new LinkedList<>();
            while (!deque.isEmpty()) {
                char cur = deque.pollFirst();
                if (cur == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pollLast());
                    }
                    sb.append(cur);
                } else {
                    stack.offer(cur);
                }
            }

            while (!stack.isEmpty()){
                sb.append(stack.pollLast());
            }

            return sb.toString();
        }
    }
}
