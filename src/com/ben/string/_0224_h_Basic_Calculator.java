package com.ben.string;

import java.util.ArrayList;
import java.util.List;

public class _0224_h_Basic_Calculator {

    public static void main(String[] args) {
//        String str = "1 + 1";
//        String str = " 2-1 + 2 ";
        String str = "(1+(4+5+2)-3)+(6+8)";
        Solution s = new Solution();
        int res = s.calculate(str);
        System.out.println(res);
    }

    static class Solution {
        public int calculate(String s) {
            int[] res = calculate(s, 0);
            return res[0];
        }

        /**
         * we treat expression between '(' and ')' as a sub-expression,
         * so every time we meet a '(', we use recursion to call this method.
         * every time we meet a ')', we return the value of expression.
         * <p>
         * return value is an int[2]
         * int[0] is the value of sub-expression
         * int[1] is the next process char's index
         */
        public int[] calculate(String s, int idx) {
            int value = 0;
            int temp = 0;
            boolean positive = true;
            while (idx < s.length()) {
                char c = s.charAt(idx);
                //Move to next index
                idx++;

                if (c >= '0' && c <= '9') {
                    temp = temp * 10 + (c - '0');
                    continue;
                }

                if (temp != 0) {
                    if (positive) {
                        value += temp;
                    } else {
                        value -= temp;
                    }
                    temp = 0;
                }

                if (c == ' ') {
                    continue;
                }
                if (c == ')') {
                    return new int[]{value, idx};
                }
                if (c == '(') {
                    int[] res = calculate(s, idx);
                    if (positive) {
                        value += res[0];
                    } else {
                        value -= res[0];
                    }

                    //fix the idx, continue after the sub-expression
                    idx = res[1];
                    continue;
                }
                if (c == '+') {
                    positive = true;
                    continue;
                }
                if (c == '-') {
                    positive = false;
                    continue;
                }
            }

            //end of expression, we need to add the last operand if it is not 0
            if (temp != 0) {
                if (positive) {
                    value += temp;
                } else {
                    value -= temp;
                }
            }

            return new int[]{value, idx};
        }


//            char[] chars = s.toCharArray();
//            int start = 0;
//            boolean positive = true;
//            List<String> list = new ArrayList<>();
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i] >= '0' && chars[i] <= '9') {
//                    //is digit, continue
//                } else {
//                    //not digit, parse number
//
//                    if (i == start) {
//                        //previous char is not a digit
//                        start = i + 1;
//                        continue;
//                    }
//
//                    String number = s.substring(start, i);
//                    if (positive) {
//                        list.add(number);
//                    } else {
//                        list.add("-" + number);
//                    }
//                    start = i + 1;
//
//                    if (chars[i] == '-') {
//                        positive = false;
//                    } else if (chars[i] == '+') {
//                        positive = true;
//                    } else if (chars[i] == '(') {
//                        list.add("(");
//                    } else if (chars[i] == ')') {
//                        list.add(")");
//                    }
//                }
//            }
//
//            return calculate(list, 0, list.size() - 1);
//        }
//
//        public int calculate(List<String> list, int start, int end) {
//            return 0;
//        }
    }
}
