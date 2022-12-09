package chapter1.section5.exercise19;

import chapter1.section5.QuickFindUF;
import chapter1.section5.exercise18.Connection;
import chapter1.section5.exercise18.RandomGridGenerator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class RandomGrid {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        QuickFindUF uf = new QuickFindUF(N);
        Connection[] connections = RandomGridGenerator.generate(N);
        double shift = setCanvas(N);
        for (Connection c : connections) {
            int p = c.p;
            int q = c.q;
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
            drawPoint(shift, p, q);
        }
    }

    private static void drawPoint(double shift, int p, int q) {
        StdDraw.point(p + shift, q + shift);
    }

    private static double setCanvas(int N) {
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenColor(Color.gray);
        for (int i = 0; i < N; i++) {
            StdDraw.line(i, 0, i, N);
            StdDraw.line(0, i, N, i);
        }
        StdDraw.setPenColor();
        StdDraw.setPenRadius(0.1);
        return 1 / 2.0;
    }

}
