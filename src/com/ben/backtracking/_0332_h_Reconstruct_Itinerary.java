package com.ben.backtracking;

import java.util.*;

public class _0332_h_Reconstruct_Itinerary {
    class Solution {

        private Map<String, PriorityQueue<String>> flights = new HashMap<>();
        private List<String> list = new LinkedList();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                flights.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
            }
            helper("JFK");
            return list;
        }

        void helper(String departure) {
            PriorityQueue<String> arrivals = flights.get(departure);
            while (arrivals != null && !arrivals.isEmpty()) {
                helper(arrivals.poll());
            }
            list.add(0, departure);
        }
    }
}
