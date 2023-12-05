package com.claudhart.algs4.chapter2.section3.exercise29;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes"})
public class SortCompare {

    private static final String originalAlg = "InitiallyRandomizingArray";
    private static final String newAlg = "RandomPartitioningItem";

    public static void main(String[] args) {
        compareWithEx25();
    }

    private static double time(String alg, Comparable[] a, int cutoff) {
        Stopwatch s = new Stopwatch();
        switch (alg) {
            case originalAlg -> com.claudhart.algs4.chapter2.section3.exercise25.Quick.sort(a, cutoff);
            case newAlg -> Quick.sort(a, cutoff);
        }
        return s.elapsedTime();
    }

    private static void compareWithEx25() {
        StdOut.printf("Compare with  initially randomizing the array:%n");
        Integer[] cutoffs = {10, 20, 50};
        StdOut.printf("%10s %22s %25s %10s%n", "N", newAlg, originalAlg, "ratio");
        for (int cutoff : cutoffs) {
            StdOut.printf("Cutoff: %d%n", cutoff);
            Comparable[] a;
            double newAlgTime, originalAlgTime;
            for (int N = 1000; N <= 1_000_000; N *= 10) {
                a = generateArray(N);
                newAlgTime = trial(newAlg, a, cutoff);
                originalAlgTime = trial(originalAlg, a, cutoff);
                StdOut.printf("%10d %22.3f %25.3f %10.1f%n", N, newAlgTime, originalAlgTime, newAlgTime / originalAlgTime);
            }
        }
    }

    private static double trial(String alg, Comparable[] a, int cutoff) {
        int T = 10;
        double totalTime = 0.0;
        for (int i = 0; i < T; i++) {
            totalTime += time(alg, a, cutoff);
        }
        return totalTime / 10;
    }

    private static Comparable[] generateArray(int length) {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < length; i++) a[i] = StdRandom.uniform(1000);
        return a;
    }
}
