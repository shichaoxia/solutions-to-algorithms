package chapter2.section4.exercise28;

import chapter2.section4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TopM {
    public static void main(String[] args) {
        trial();
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
        
        public final double distance;

        public Point(double x, double y, double z) {
            this.distance = Math.sqrt(x * x + y * y + z * z);
        }

        public int compareTo(Point that) {
            return Double.compare(this.distance, that.distance);
        }
    }
}
