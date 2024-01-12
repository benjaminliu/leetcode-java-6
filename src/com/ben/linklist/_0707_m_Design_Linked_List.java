package com.ben.linklist;

public class _0707_m_Design_Linked_List {

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.addAtIndex(1, 0);


        System.out.println(l.get(0));
    }

    static class MyLinkedList {

        static class Node {
            public int val;
            public Node next;
        }

        private Node dummy;
        private int size;

        public MyLinkedList() {
            dummy = new Node();
            size = 0;
        }

        public int get(int index) {
            if (index < size) {
                int idx = 0;
                Node cur = dummy.next;
                while (idx < index) {
                    cur = cur.next;
                    idx++;
                }

                return cur.val;
            }

            return -1;
        }

        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            node.next = dummy.next;
            dummy.next = node;
            size++;
        }

        public void addAtTail(int val) {
            if (dummy.next == null) {
                addAtHead(val);
                return;
            }

            Node cur = dummy;
            while (cur.next != null) {
                cur = cur.next;
            }

            Node node = new Node();
            node.val = val;
            cur.next = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index == size) {
                addAtTail(val);
                return;
            }

            int pre = index - 1;
            int idx = -1;
            Node cur = dummy;
            while (idx < pre) {
                cur = cur.next;
                idx++;
            }

            Node node = new Node();
            node.val = val;
            node.next = cur.next;

            cur.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }

            int pre = index - 1;
            int idx = -1;
            Node cur = dummy;
            while (idx < pre) {
                cur = cur.next;
                idx++;
            }

            cur.next = cur.next.next;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
