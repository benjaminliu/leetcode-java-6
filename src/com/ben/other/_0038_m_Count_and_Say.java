package com.ben.other;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0038_m_Count_and_Say {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.countAndSay(1));
//        System.out.println(s.countAndSay(2));
//        System.out.println(s.countAndSay(3));
//        System.out.println(s.countAndSay(4));
//        System.out.println(s.countAndSay(5));
//        System.out.println(s.countAndSay(6));
//        System.out.println(s.countAndSay(7));

        PrintUtil.printList(s.reverseCountAndSay("12345"));
    }

    static class Solution {
        private static String[] cache;

        static {
            cache = new String[31];
            cache[0] = "1";
        }

        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }

            String value = cache[n];
            if (value == null) {
                value = generateFromPrevious(n - 1);
                cache[n] = value;
            }

            return value;
        }

        private String generateFromPrevious(int n) {
            String previous = countAndSay(n);

            StringBuilder sb = new StringBuilder();
            char cur = previous.charAt(0);
            int count = 1;
            for (int i = 1; i < previous.length(); i++) {
                if (previous.charAt(i) == cur) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(cur);

                    cur = previous.charAt(i);
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(cur);

            return sb.toString();
        }


        public List<String> reverseCountAndSay(String input) {
            List<String> result = new ArrayList<>();
            if (null == input || input.length() <= 1) return result;

            if (input.length() == 2) {
                int count = Integer.valueOf(input.substring(0, 1));
                char digit = input.charAt(1);
                result.add(getString(count, digit));
                return result;
            } else if (input.length() == 3) {
                int count = Integer.valueOf(input.substring(0, 2));
                char digit = input.charAt(2);
                result.add(getString(count, digit));
                return result;
            }

            //Whole string
            int count = Integer.valueOf(input.substring(0, input.length() - 1));
            char digit = input.charAt(input.length() - 1);
            result.add(getString(count, digit));

            //Separate into 2 substrings
            for (int i = 2; i < input.length(); i++) {
                List<String> left = reverseCountAndSay(input.substring(0, i));
                List<String> right = reverseCountAndSay(input.substring(i));
                for (String l : left) {
                    for (String r : right) {
                        result.add(new String(l + r));
                    }
                }
            }

            return result;
        }

        private String getString(int count, char digit) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) sb.append(digit);
            return sb.toString();
        }
    }
}
