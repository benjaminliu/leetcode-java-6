package com.ben.linklist;

import com.ben.common.ListNode;

public class _0206_e_Reverse_Linked_List {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;
            head.next = null;
            ListNode newHead = reverseList(next);
            next.next = head;

            return newHead;
        }
    }
}
