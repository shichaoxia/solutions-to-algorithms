package ch1.sec5.ex16;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

@SuppressWarnings("DuplicatedCode")
public class QuickUnionUF {
    private final int[] id;
    private int count;
    private int idAccessNum = 0;

    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
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
        yAixLabel(40);
        yAixLabel(1000);
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
        int x = 1000;
        int y = 1500;
        StdDraw.setXscale(-x / 10.0, x);
        StdDraw.setYscale(-y / 10.0, y);
        StdDraw.line(0, 0, x, 0);
        StdDraw.line(0, 0, 0, y);
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        if (p == getIdAt(p)) return p;
        else return find(getIdAt(p));
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        setIdAt(pRoot, qRoot);

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
