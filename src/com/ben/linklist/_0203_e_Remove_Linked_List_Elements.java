package com.ben.linklist;

import com.ben.common.ListNode;

public class _0203_e_Remove_Linked_List_Elements {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode cur = dummy;

            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }
    }
}
