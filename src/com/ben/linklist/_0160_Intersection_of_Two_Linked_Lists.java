package com.ben.linklist;

import com.ben.common.ListNode;

public class _0160_Intersection_of_Two_Linked_Lists {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;

            int switchCount = 0;

            while (curA != null && curB != null) {
                if (curA == curB) {
                    return curA;
                }

                curA = curA.next;
                if (curA == null) {
                    if (switchCount == 2) {
                        break;
                    }
                    switchCount++;
                    curA = headB;
                }
                curB = curB.next;
                if (curB == null) {
                    if (switchCount == 2) {
                        break;
                    }
                    switchCount++;
                    curB = headA;
                }
            }

            return null;
        }
    }
}
