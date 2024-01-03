package chapter2.section3.exercise11;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class ModifiedQuick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (le(a[++i], v)) if (i == hi) break;
            while (ge(a[--j], v)) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static boolean le(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    public static boolean ge(Comparable v, Comparable w) {
        return v.compareTo(w) >= 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int T = 10;
        int NStart = 500;
        double previous = trial(NStart, T);
        StdOut.printf("%10s %10s %10s%n", "N", "time", "ratio");
        for (int N = 2 * NStart; N <= 200_000; N *= 2) {
            double time = trial(N, T);
            StdOut.printf("%10d %10.3f %10.1f%n", N, time, time / previous);
            previous = time;
        }
    }

    public static double trial(int N, int T) {
        Integer[] a = generateArrayOfLength(N);
        double totalTime = 0.0;
        for (int i = 0; i < T; i++) {
            totalTime += time(a);
        }
        return totalTime / T;
    }

    public static double time(Comparable[] a) {
        Stopwatch stopwatch = new Stopwatch();
        sort(a);
        return stopwatch.elapsedTime();
    }

    public static Integer[] generateArrayOfLength(int length) {
        Integer[] a = new Integer[length];
        Integer[] distinctKeys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < length; i++) a[i] = distinctKeys[i % distinctKeys.length];
        return a;
    }
}
