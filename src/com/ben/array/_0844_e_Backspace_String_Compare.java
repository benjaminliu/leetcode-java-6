package com.ben.array;


public class _0844_e_Backspace_String_Compare {

    public static void main(String[] args) {
//        String s = "ab#c";
//        String t = "ad#c";

//        String s = "ab##";
//        String t = "c#d#";

//        String s = "nzp#o#g";
//        String t = "b#nzp#o#g";

        String s = "c#a#c";
        String t = "c";

        System.out.println(new Solution().backspaceCompare(s, t));
    }

    static class Solution {

        private static final char BACK_SPACE = '#';

        private int sIdx;
        private int tIdx;

        public boolean backspaceCompare(String s, String t) {
            sIdx = s.length() - 1;
            tIdx = t.length() - 1;

            while (sIdx >= 0 || tIdx >= 0) {
                Character sChar = getNextSChar(s);
                Character tChar = getNextTChar(t);

                if (sChar != tChar) {
                    return false;
                }
            }

            return sIdx == tIdx;
        }

        private Character getNextSChar(String str) {
            int skip = 0;
            while (true) {
                if (sIdx < 0) {
                    return null;
                }

                char c = str.charAt(sIdx--);
                if (c == BACK_SPACE) {
                    skip++;
                    continue;
                }

                if (skip > 0) {
                    skip--;
                    continue;
                }

                return c;
            }
        }

        private Character getNextTChar(String str) {
            int skip = 0;
            while (true) {
                if (tIdx < 0) {
                    return null;
                }

                char c = str.charAt(tIdx--);
                if (c == BACK_SPACE) {
                    skip++;
                    continue;
                }

                if (skip > 0) {
                    skip--;
                    continue;
                }

                return c;
            }
        }
    }
}
