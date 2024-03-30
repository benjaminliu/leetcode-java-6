package com.ben.linklist;

import com.ben.common.ListNode;

public class _0025_h_Reverse_Nodes_in_k_Group {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            int length = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                length++;
            }

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode preBreak = dummy;
            ListNode pre = null;
            ListNode next = null;

            cur = dummy.next;
            while (length >= k) {
                length -= k;

                for (int i = 0; i < k; i++) {
                    next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }

                next = preBreak.next;
                preBreak.next.next = cur;
                preBreak.next = pre;
                preBreak = next;
            }

            return dummy.next;
        }
    }
}
