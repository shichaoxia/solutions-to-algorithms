package com.claudhart.algs4.chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionCompressionUF {

    private final int[] id;
    private int count;

    public QuickUnionCompressionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionCompressionUF uf = new QuickUnionCompressionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
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

    public int findAndCompress(int p) {
        int root = find(p);
        compressComponent(p, root);
        return root;
    }

    public void compressComponent(int p, int root) {
        if (p != root) {
            int next = id[p];
            id[p] = root;
            compressComponent(next, root);
        }
    }

    public void union(int p, int q) {
        int pRoot = findAndCompress(p);
        int qRoot = findAndCompress(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

}
