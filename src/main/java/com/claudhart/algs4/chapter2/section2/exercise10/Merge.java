package com.claudhart.algs4.chapter2.section2.exercise10;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy"})
public class Merge {

    private static Comparable[] aux;  // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];  // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);           // Sort left half.
        sort(a, mid + 1, hi);       // Sort right half.
        merge(a, lo, mid, hi);      // Merge results.
    }

    // tag::solution[]
    @SuppressWarnings("GrazieInspection")
    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        leftIncRightDecCopy(a, lo, mid, hi);

        int i = lo, j = hi;

        for (int k = lo; k <= hi; k++)                  // Merge back to a[lo..hi].
            if (less(aux[j], aux[i])) a[k] = aux[j--];  // Right is smaller (take from right)
            else a[k] = aux[i++];                       // Otherwise take from left
    }

    /**
     * Copy a[lo..mid] to aux[lo..mid] and a[mid+1..hi] to aux[hi..mid+1].
     */
    @SuppressWarnings("GrazieInspection")
    public static void leftIncRightDecCopy(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++)
            aux[i] = a[i];
        for (int i = mid + 1, j = hi; i <= hi; i++, j--)
            aux[i] = a[j];
    }
    // end::solution[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static double time(Double[] a, int T) {
        double totalTime = 0.0;
        Stopwatch sw;
        for (int i = 0; i < T; i++) {
            sw = new Stopwatch();
            sort(a);
            totalTime += sw.elapsedTime();
        }
        return totalTime / T;
    }

    public static double originalTime(Double[] a, int T) {
        double totalTime = 0.0;
        Stopwatch sw;
        for (int i = 0; i < T; i++) {
            sw = new Stopwatch();
            com.claudhart.algs4.chapter2.section2.Merge.sort(a);
            totalTime += sw.elapsedTime();
        }
        return totalTime / T;
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++)
            a[i] = StdRandom.uniform();
        return a;
    }

    public static void main(String[] args) {
        StdOut.printf("%10s %10s %10s %10s%n", "N", "Time", "Original", "Ratio");
        for (int N = 5_000; N < 1_000_000; N += N) {
            double time = time(randomArray(N), 5);
            double originalTime = originalTime(randomArray(N), 5);
            StdOut.printf("%10d %10.3f %10.3f %10.1f%n", N, time, originalTime, time / originalTime);
        }
    }
}
