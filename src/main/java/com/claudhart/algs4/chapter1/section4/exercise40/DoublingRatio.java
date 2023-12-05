package com.claudhart.algs4.chapter1.section4.exercise40;

import com.claudhart.algs4.chapter1.section4.ThreeSum;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {
    public static int timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        return ThreeSum.count(a);
    }

    public static void main(String[] args) {
        StdOut.printf("%10s %10s %10s%n", "N", "Triples", "Ratio");
        int prev = timeTrial(125);
        for (int N = 250; N <= 16000; N += N) {
            int number = timeTrial(N);
            StdOut.printf("%10d %10d ", N, number);
            System.out.printf("%10.1f%n", (double) number / prev);
            prev = number;
        }
    }
}
