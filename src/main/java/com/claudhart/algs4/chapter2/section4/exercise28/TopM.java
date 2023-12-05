package com.claudhart.algs4.chapter2.section4.exercise28;

import com.claudhart.algs4.chapter2.section4.MaxPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TopM {
    public static void main(String[] args) {
        trial();
    }

    @SuppressWarnings("unused")
    private static void readPoints(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxPQ<Point> pq = new MaxPQ<>(M + 1);
        while (!StdIn.isEmpty()) {
            String[] line = StdIn.readLine().split("\\s+");
            double x = Double.parseDouble(line[0]);
            double y = Double.parseDouble(line[1]);
            double z = Double.parseDouble(line[2]);
            pq.insert(new Point(x, y, z));
            if (pq.size() > M) pq.delMax();
        }
        while (!pq.isEmpty()) StdOut.println(pq.delMax());
    }

    private static void trial() {
        int N = 100000000;
        int M = 10000;
        Stopwatch timer = new Stopwatch();
        simulateReadingPoints(N, M);
        double time = timer.elapsedTime();
        StdOut.printf("N = %d, M = %d, time = %.3f\n", N, M, time);
    }

    private static void simulateReadingPoints(int N, int M) {
        MaxPQ<Point> pq = new MaxPQ<>(M + 1);
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            double z = Math.random();
            pq.insert(new Point(x, y, z));
            if (pq.size() > M) pq.delMax();
        }
    }

    private static class Point implements Comparable<Point> {
        @SuppressWarnings("unused")
        public final double x;
        @SuppressWarnings("unused")
        public final double y;
        @SuppressWarnings("unused")
        public final double z;

        public final double distance;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;

            this.distance = Math.sqrt(x * x + y * y + z * z);
        }

        public int compareTo(Point that) {
            return Double.compare(this.distance, that.distance);
        }
    }
}
