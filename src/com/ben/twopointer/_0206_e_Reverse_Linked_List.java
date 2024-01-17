package com.ben.twopointer;

import com.ben.common.ListNode;

public class _0206_e_Reverse_Linked_List {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;

            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            return pre;
        }
    }
}
