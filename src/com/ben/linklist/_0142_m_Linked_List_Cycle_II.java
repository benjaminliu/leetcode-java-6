package com.ben.linklist;

import com.ben.common.ListNode;

public class _0142_m_Linked_List_Cycle_II {

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null ){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    slow = head;
                    while (slow != fast){
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }

            return null;
        }
    }
}
