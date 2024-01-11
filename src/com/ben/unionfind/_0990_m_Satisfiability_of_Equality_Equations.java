package com.ben.unionfind;

import java.util.ArrayList;
import java.util.List;

public class _0990_m_Satisfiability_of_Equality_Equations {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] list = new String[]{"c==c", "b==d", "x!=z" };

        System.out.println(s.equationsPossible(list));
    }

    static class Solution {
        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);

            List<String> equalList = new ArrayList<>();
            List<String> nonEqualList = new ArrayList<>();

            for (String e : equations) {
                if (e.charAt(1) == '=') {
                    equalList.add(e);
                } else {
                    nonEqualList.add(e);
                }
            }

            for (String e : equalList) {
                int x = e.charAt(0) - 'a';
                int y = e.charAt(3) - 'a';

                uf.union(x, y);
            }

            for (String e : nonEqualList) {
                int x = e.charAt(0) - 'a';
                int y = e.charAt(3) - 'a';

                if (uf.connected(x, y)) {
                    return false;
                }
            }

            return true;
        }
    }
}
