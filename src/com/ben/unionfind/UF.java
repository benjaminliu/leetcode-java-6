package com.ben.unionfind;

public class UF {
    private int count;

    private int[] parents;

    //optimization, use size to know the size of a tree
    //So when set parent, we can make the tree more balance
    //(make the smaller tree as child, not parent)
    private int[] sizes;

    public UF(int n) {
        this.count = n;
        parents = new int[n];
        sizes = new int[n];

        for (int i = 0; i < n; i++) {
            //Connect to itself by default
            parents[i] = i;
            //optimization
            sizes[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            //Already connect
            return;
        }

        //parents[rootQ] = rootP;

        //optimization
        //make the smaller tree as child
        if (sizes[rootP] > sizes[rootQ]) {
            parents[rootQ] = rootP;
            sizes[rootP] += sizes[rootQ];
        } else {
            parents[rootP] = rootQ;
            sizes[rootP] += sizes[rootP];
        }

        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count() {
        return count;
    }

    private int find(int x) {
        while (parents[x] != x) {
            //optimization
            //make x's parent to its root
            parents[x] = parents[parents[x]];
            x = parents[x];
        }

        return x;
    }
}
