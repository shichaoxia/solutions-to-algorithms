package com.claudhart.algs4.chapter1.section5.exercise20;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class WeightedQuickUnionUF {
    private final ArrayList<Integer> id = new ArrayList<>();
    private final ArrayList<Integer> sz = new ArrayList<>();
    private int count = 0;
    private int nextIdToAdd = 0;

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF();
        for (int i = 0, j = StdIn.readInt(); i < j; i++) {
            StdOut.println(uf.newSite());
        }
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

    public int newSite() {
        id.add(nextIdToAdd);
        sz.add(1);
        ++count;
        return nextIdToAdd++;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        if (p == id.get(p)) return p;
        else return find(id.get(p));
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        int smaller = sz.get(pRoot) <= sz.get(qRoot) ? pRoot : qRoot;
        int larger = smaller == pRoot ? qRoot : pRoot;

        id.set(smaller, larger);
        sz.set(larger, sz.get(smaller));

        count--;
    }

}
