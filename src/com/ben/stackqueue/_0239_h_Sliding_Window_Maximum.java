package com.ben.stackqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _0239_h_Sliding_Window_Maximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MyQueue queue = new MyQueue();
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }

            int[] res = new int[nums.length - k + 1];

            res[0] = queue.peak();

            int idx = 1;
            for (int i = k; i < nums.length; i++) {
                queue.poll(nums[i - k]);
                queue.add(nums[i]);
                res[idx] = queue.peak();
                idx++;
            }
            return res;
        }

        static class MyQueue {
            private Deque<Integer> deque = new LinkedList<>();

            public void poll(int i) {
                if (!deque.isEmpty() && i == deque.peek()) {
                    deque.poll();
                }
            }

            public void add(int i) {
                while (!deque.isEmpty() && i > deque.getLast()) {
                    deque.removeLast();
                }
                deque.add(i);
            }

            public int peak() {
                return deque.peek();
            }
        }
    }
}
