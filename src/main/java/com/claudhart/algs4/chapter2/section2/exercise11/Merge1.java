package com.claudhart.algs4.chapter2.section2.exercise11;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import com.claudhart.algs4.chapter2.section2.Merge;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
public class Merge1 {

    private static Comparable[] aux;  // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];  // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    // tag::solution[]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        // length <= 15, use insertion sort
        int length = hi - lo + 1;
        if (length <= 15) {
            Insertion.sort(a, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    // end::solution[]

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)           // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];        // left half exhausted (take from the right)
            else if (j > hi) a[k] = aux[i++];    // right half exhausted (take from the left)
            else if (less(aux[j], aux[i])) a[k] = aux[j++];  // right is smaller (take from right)
            else a[k] = aux[i++];                            // take from left
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        StdOut.printf("%10s %10s %10s %10s%n", "N", "Time", "Original", "Ratio");
        for (int N = 5_000; N <= 500_000; N += N) {
            double time = time(randomArray(N), 10);
            double originalTime = originalTime(randomArray(N), 10);
            StdOut.printf("%10d %10.3f %10.3f %10.1f%n", N, time, originalTime, time / originalTime);
        }
    }

    public static double time(Double[] a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            sort(a);
            time += sw.elapsedTime();
        }
        return time / T;
    }

    public static double originalTime(Double[] a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            Merge.sort(a);
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
