package com.claudhart.algs4.chapter2.section2.exercise16;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatio {
    public static void main(String[] args) {
        double previous = time(randomArray(1000), 10);
        StdOut.printf("%10s %10s %10s %10s %10s%n", "N", "time", "origin", "/previous", "/origin");
        for (int N = 2000; N <= 100_000; N += N) {
            double time = time(randomArray(N), 10);
            double originalTime = originalTime(randomArray(N), 10);
            StdOut.printf("%10d %10.3f %10.3f %10.1f %10.1f%n", N, time, originalTime, time / previous, time / originalTime);
            previous = time;
        }
    }

    public static double time(Double[] a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            NaturalMergesort.sort(a);
            time += sw.elapsedTime();
        }
        return time / T;
    }

    @SuppressWarnings("DuplicatedCode")
    public static double originalTime(Double[] a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            com.claudhart.algs4.chapter2.section2.Merge.sort(a);
            time += sw.elapsedTime();
        }
        return time / T;
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++)
            a[i] = StdRandom.uniform();
        return a;
    }
}