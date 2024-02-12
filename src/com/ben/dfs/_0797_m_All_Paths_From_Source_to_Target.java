package com.ben.dfs;

import java.util.ArrayList;
import java.util.List;

public class _0797_m_All_Paths_From_Source_to_Target {
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(0);

            dfs(graph, 0, list, res);

            return res;
        }

        private void dfs(int[][] graph, int idx, List<Integer> list, List<List<Integer>> res) {
            if (idx == graph.length - 1) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < graph[idx].length; i++) {
                int next = graph[idx][i];
                list.add(next);
                dfs(graph, next, list, res);
                list.removeLast();
            }
        }
    }
}
