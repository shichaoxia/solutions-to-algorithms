package com.claudhart.algs4.chapter1.section5.exercise14;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class WeightedQuickUnionHeightUF {

    private final int[] id;
    private final int[] ht;
    private int count;

    public WeightedQuickUnionHeightUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        ht = new int[N];
        for (int i = 0; i < N; i++) ht[i] = 0;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionHeightUF uf = new WeightedQuickUnionHeightUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println("id[]: " + Arrays.toString(uf.id));
        StdOut.println("ht[]: " + Arrays.toString(uf.ht));
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        if (p == id[p]) return p;
        else return find(id[p]);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        int shorter = ht[pRoot] <= ht[qRoot] ? pRoot : qRoot;
        int taller = shorter == pRoot ? qRoot : pRoot;

        id[shorter] = taller;
        if (ht[shorter] == ht[taller]) ht[taller] += 1;

        count--;
    }

}
