package com.claudhart.algs4.chapter1.section5.exercise16;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

@SuppressWarnings("DuplicatedCode")
public class QuickFindUF {

    private final int[] id;
    private int count;
    private int idAccessNum = 0;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        setupDraw();
        for (int total = 0, i = 1; !StdIn.isEmpty(); ++i) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                StdOut.printf("i: %3d, cost: %4d, cumulative average: %3d%n", i, 0, total / i);
                continue;
            }
            uf.union(p, q);
            int cost = uf.getIdAccessNumAndReset();
            total += cost;
            StdOut.printf("i: %3d, cost: %4d, cumulative average: %3d%n", i, cost, total / i);
            drawPoints(i, cost, total);
        }
        StdOut.println(uf.count() + " components");
    }

    private static void setupDraw() {
        xAndYScale();
        yAixLabel(0);
        yAixLabel(461);
        yAixLabel(630);
        yAixLabel(1247);
        StdDraw.setPenRadius(0.005);
    }

    private static void drawPoints(int i, int cost, int total) {
        StdDraw.setPenColor(Color.gray);
        StdDraw.point(i, cost);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(i, (double) total / i);
    }

    private static void yAixLabel(int num) {
        StdDraw.textRight(0, num, Integer.toString(num));
    }

    private static void xAndYScale() {
        StdDraw.setXscale(-1000 / 10.0, 1000);
        StdDraw.setYscale(-1500 / 10.0, 1500);
        StdDraw.line(0, 0, 1000, 0);
        StdDraw.line(0, 0, 0, 1500);
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return getIdAt(p);
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            if (getIdAt(i) == pID) setIdAt(i, qID);
        count--;
    }

    private int getIdAt(int idx) {
        idAccessNum += 1;
        return id[idx];
    }

    private void setIdAt(int idx, int val) {
        idAccessNum += 1;
        id[idx] = val;
    }

    public int getIdAccessNumAndReset() {
        int oldNum = idAccessNum;
        idAccessNum = 0;
        return oldNum;
    }

}
