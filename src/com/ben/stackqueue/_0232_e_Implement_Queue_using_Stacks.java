package com.ben.stackqueue;

import java.util.Stack;

public class _0232_e_Implement_Queue_using_Stacks {

    class MyQueue {

        private Stack<Integer> in;
        private Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            transferFromInToOutIfNecessary();

            return out.pop();
        }

        public int peek() {
            transferFromInToOutIfNecessary();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void transferFromInToOutIfNecessary() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }


}
