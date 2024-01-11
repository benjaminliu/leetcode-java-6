package com.ben.unionfind;

public class _0323_m_Number_of_Connected_Components_in_an_Undirected_Graph {

    public class Solution {


        public int countComponents(int n, int[][] edges) {
            UF uf = new UF(n);
            for (int i = 0; i < edges.length; i++) {
                uf.union(edges[i][0], edges[i][1]);
            }
            return uf.count();
        }
    }
}
