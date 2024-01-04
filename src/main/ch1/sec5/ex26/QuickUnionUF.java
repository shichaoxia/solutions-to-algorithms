package ch1.sec5.ex26;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

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
        int N = Integer.parseInt(args[0]);
        QuickUnionUF uf = new QuickUnionUF(N);
        int count;
        ArrayList<Integer> costs = new ArrayList<>();
        ArrayList<Integer> amortizedCosts = new ArrayList<>();
        for (int total = 0, i = 1; true; ++i) {
            int m = StdRandom.uniform(N);
            int n = StdRandom.uniform(N);
            if (uf.connected(m, n)) {
                costs.add(0);
                amortizedCosts.add(total / i);
                continue;
            }
            uf.union(m, n);
            int cost = uf.getIdAccessNumAndReset();
            total += cost;
            costs.add(cost);
            amortizedCosts.add(total / i);
            if (uf.count() == 1) {
                count = i;
                break;
            }
        }
        int maxX = count;
        int maxY = Collections.max(costs) / 10;

        StdDraw.setXscale(-0.1 * maxX, 1.1 * maxX);
        StdDraw.setYscale(-0.1 * maxY, 1.1 * maxY);

        StdDraw.line(0, 0, maxX, 0);
        StdDraw.line(0, 0, 0, maxY);
        StdDraw.line(0, maxY, maxX, maxY);
        StdDraw.line(maxX, 0, maxX, maxY);

        StdDraw.text(0.55 * maxX, 1.05 * maxY, "N=" + N);

        StdDraw.textRight(0, Collections.min(amortizedCosts), Integer.toString(Collections.min(amortizedCosts)));
        StdDraw.textRight(0, Collections.max(amortizedCosts), Integer.toString(Collections.max(amortizedCosts)));

        StdDraw.textRight(0, maxY, Integer.toString(maxY));
        StdDraw.textLeft(maxX, 0, Integer.toString(maxX));

        StdDraw.setPenRadius(0.008);
        StdDraw.setPenColor(Color.gray);
        for (int i = 0; i < count; i++) {
            if (costs.get(i) != 0)
                StdDraw.point(i, costs.get(i));
        }
        StdDraw.setPenColor(Color.red);
        for (int i = 0; i < count; i++) {
            StdDraw.point(i, amortizedCosts.get(i));
        }
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
