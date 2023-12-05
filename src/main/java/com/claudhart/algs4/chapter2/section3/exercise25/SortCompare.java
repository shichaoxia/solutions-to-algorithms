package com.claudhart.algs4.chapter2.section3.exercise25;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class SortCompare {

    private static final String originalAlg = "quick";
    private static final String newAlg = "cutoff";

    public static void main(String[] args) {
//        compareM();
        compareWithOriginal();
    }

    private static double time(String alg, Comparable[] a, int cutoff) {
        Stopwatch s = new Stopwatch();
        switch (alg) {
            case originalAlg -> com.claudhart.algs4.chapter2.section3.Quick.sort(a);
            case newAlg -> Quick.sort(a, cutoff);
        }
        return s.elapsedTime();
    }

    private static void compareM() {
        StdOut.printf("%nComparing the performance of different M:%n");
        StdOut.printf("%10s %10s %10s %10s %10s%n", "M\\N", "10^3", "10^4", "10^5", "10^6");
        double time;
        Comparable[] a;
        for (int M = 0; M <= 30; M++) {
            StdOut.printf("%10d", M);
            for (int N = 1_000; N <= 1_000_000; N *= 10) {
                a = generateArray(N);
                time = trial(newAlg, a, M);
                StdOut.printf(" %10.4f", time);
            }
            StdOut.printf("%n");
        }
    }

    private static void compareWithOriginal() {
        StdOut.printf("%nCompare with original:%n");
        StdOut.printf("%10s %10s %10s %10s%n", "N", newAlg, originalAlg, "ratio");
        int cutoff = 10;
        Comparable[] a;
        double newAlgTime, originalAlgTime;
        for (int N = 1000; N <= 1_000_000; N *= 10) {
            a = generateArray(N);
            newAlgTime = trial(newAlg, a, cutoff);
            originalAlgTime = trial(originalAlg, a, cutoff);
            StdOut.printf("%10d %10.3f %10.3f %10.2f%n", N, newAlgTime, originalAlgTime, newAlgTime / originalAlgTime);
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
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
