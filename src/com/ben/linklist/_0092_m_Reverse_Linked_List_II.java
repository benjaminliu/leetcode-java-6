package com.ben.linklist;

import com.ben.common.ListNode;

public class _0092_m_Reverse_Linked_List_II {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode preBreak = dummy;
            for (int i = 1; i < left; i++) {
                preBreak = preBreak.next;
            }

            ListNode pre = null;
            ListNode cur = preBreak.next;
            ListNode next = null;
            for (int i = 0; i < right - left + 1; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            preBreak.next.next = cur;
            preBreak.next = pre;
            return dummy.next;
        }
    }
}
