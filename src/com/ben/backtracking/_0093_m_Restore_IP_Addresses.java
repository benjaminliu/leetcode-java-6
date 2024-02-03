package com.ben.backtracking;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0093_m_Restore_IP_Addresses {
    public static void main(String[] args) {
        String s = "25525511135";

        PrintUtil.printList(new Solution().restoreIpAddresses(s));
    }

    static
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() < 4 || s.length() > 12) {
                return res;
            }

            helper(s, 0, 4, new ArrayList<>(), res);
            return res;
        }

        private void helper(String s, int start, int seg, ArrayList<String> list, List<String> res) {
            if (seg == 1) {
                if (isValid(s, start, s.length() - 1)) {
                    list.add(s.substring(start, s.length()));
                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(0));
                    for (int i = 1; i < 4; i++) {
                        sb.append(".").append(list.get(i));
                    }
                    res.add(sb.toString());
                    list.removeLast();
                }
                return;
            }

            int lengthLeft = s.length() - start;

            if (lengthLeft > seg * 3) {
                return;
            }

            if (lengthLeft < seg) {
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isValid(s, start, i)) {
                    //Current number is invalid, add one digit at the right will also be invalid
                    break;
                }

                list.add(s.substring(start, i + 1));
                helper(s, i + 1, seg - 1, list, res);
                list.removeLast();
            }
        }

        private boolean isValid(String s, int start, int end) {
            if (start > end) {
                return false;
            }

            if (s.charAt(start) == '0' && start != end) {
                return false;
            }

            int num = 0;
            for (int i = start; i <= end; i++) {
                int digit = s.charAt(i) - '0';
                num = num * 10 + digit;
                if (num > 255) {
                    return false;
                }
            }
            return true;
        }
    }
}
