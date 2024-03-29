package ch2.sec4.ex36;

import ch1.sec4.Stopwatch;
import ch2.sec4.MaxPQ;
import edu.princeton.cs.algs4.StdRandom;

public class PerformanceDriverI {

    public static void main(String[] args) {
        int T = 10;
        int N = 100_000;
        double prev = avgTime(N / 2, T);
        System.out.println("T = " + T);
        System.out.printf("%10s %10s %10s%n", "N", "time", "ratio");
        for (int i = N; i < 10_000_000; i *= 2) {
            double time = avgTime(i, T);
            System.out.printf("%10d %10.3f %10.1f%n", i, time, time / prev);
            prev = time;
        }
    }

    private static void trial(MaxPQ<Double> pq, int N) {
        for (int i = 0; i < N; i++) {
            pq.insert(StdRandom.uniform());
        }
        for (int i = 0; i < N / 2; i++) {
            pq.delMax();
        }
        for (int i = 0; i < N / 2; i++) {
            pq.insert(StdRandom.uniform());
        }
        for (int i = 0; i < N; i++) {
            pq.delMax();
        }
    }

    private static double time(int N) {
        MaxPQ<Double> pq = new MaxPQ<>(N);
        Stopwatch timer = new Stopwatch();
        trial(pq, N);
        return timer.elapsedTime();
    }

    private static double avgTime(int N, int T) {
        double total = 0.0;
        for (int i = 0; i < T; i++) {
            total += time(N);
        }
        return total / T;
    }
}
