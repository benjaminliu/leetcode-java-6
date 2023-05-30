package com.ben.linklist;

import com.ben.common.ListNode;

public class _0024_m_Swap_Nodes_in_Pairs {

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode cur = dummy;

            while (cur.next != null && cur.next.next != null) {
                ListNode next = cur.next;
                ListNode nextNext = next.next;
                ListNode nextNextNext = nextNext.next;

                cur.next = nextNext;
                nextNext.next = next;
                next.next = nextNextNext;

                cur = cur.next.next;
            }

            return dummy.next;
        }
    }
}
