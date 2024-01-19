package com.ben.stackqueue;

import java.util.Stack;

public class _0150_m_Evaluate_Reverse_Polish_Notation {

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> operands = new Stack<>();

            for (String s : tokens) {
                if (s.equals("*")) {
                    int right = operands.pop();
                    int left = operands.pop();
                    int temp = left * right;
                    operands.push(temp);
                } else if (s.equals("/")) {
                    int right = operands.pop();
                    int left = operands.pop();
                    int temp = left / right;
                    operands.push(temp);
                } else if (s.equals("+")) {
                    int right = operands.pop();
                    int left = operands.pop();
                    int temp = left + right;
                    operands.push(temp);
                } else if (s.equals("-")) {
                    int right = operands.pop();
                    int left = operands.pop();
                    int temp = left - right;
                    operands.push(temp);
                } else {
                    int i = Integer.parseInt(s);
                    operands.push(i);
                }
            }

            return operands.pop();
        }
    }
}
