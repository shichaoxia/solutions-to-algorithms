package ch2.sec2.ex8;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
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
        // Merge a[lo..mid] with a[mid+1..hi].

        // Skip the merge if sorted
        if (a[mid].compareTo(a[mid + 1]) <= 0)
            return;

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)           // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];        // left half exhausted (take from the right)
            else if (j > hi) a[k] = aux[i++];    // right half exhausted (take from the left)
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }
    // end::solution[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        int N = 32_000;
        double previous = time(sortedArray(N));
        StdOut.printf("%10s %10s %10s%n", "N", "time", "ratio");
        for (N += N; N < 100_000_000; N += N) {
            double time = time(sortedArray(N));
            StdOut.printf("%10d %10.3f %10.1f%n", N, time, time / previous);
            previous = time;
        }
    }

    public static double time(Integer[] a) {
        Stopwatch sw = new Stopwatch();
        sort(a);
        return sw.elapsedTime();
    }

    public static Integer[] sortedArray(int length) {
        Integer[] a = new Integer[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
