package com.ben.string;

public class _0541_e_Reverse_String_II {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;

        System.out.println(new Solution().reverseStr(s, k));
    }

    static
    class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int i = 0;
            while (i < s.length()) {
                int j = i + k - 1;
                int right;
                if (j >= s.length()) {
                    right = s.length() - 1;
                } else {
                    right = j;
                }
                int left = i;
                while (left < right) {
                    char tmp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = tmp;

                    left++;
                    right--;
                }

                i = j + 1 + k;
            }

            return new String(chars);
        }
    }


    class Solution2 {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < s.length(); i += 2 * k) {
                int left = i;
                int right = Math.min(s.length() - 1, i + k - 1);

                while (left < right) {
                    char tmp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = tmp;

                    left++;
                    right--;
                }
            }

            return new String(chars);
        }
    }
}
