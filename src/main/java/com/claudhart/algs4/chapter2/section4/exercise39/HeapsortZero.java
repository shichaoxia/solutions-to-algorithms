package com.claudhart.algs4.chapter2.section4.exercise39;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class HeapsortZero {
    public static void main(String[] args) {
        System.out.printf("%10s %10s %10s\n", "N", "cons time", "percent");
        for (int N = 10_000; N <= 10_000_000; N *= 10) {
            trial(N);
        }
    }

    private static void trial(int N) {
        Double[] a = generateRandomArray(N);
        double constructionTime = construction(a);
        double sortdownTime = sortdown(a);
        System.out.printf("%10d %10.3f %10.3f\n", N, constructionTime, constructionTime / (sortdownTime + constructionTime));
    }

    private static Double[] generateRandomArray(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        return a;
    }

    public static double construction(Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        int N = a.length - 1;
        for (int k = (N - 1) / 2; k >= 0; k--)
            sink(a, k, N);
        return timer.elapsedTime();
    }

    public static double sortdown(Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        int N = a.length - 1;
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
        return timer.elapsedTime();
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && less(a, j, j + 1)) j += 1;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
