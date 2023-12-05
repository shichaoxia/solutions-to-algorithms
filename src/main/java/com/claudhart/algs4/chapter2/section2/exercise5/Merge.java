package com.claudhart.algs4.chapter2.section2.exercise5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
public class Merge {

    private static Comparable[] aux;  // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];  // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
//        StdOut.printf("sort(%d, %d)%n", lo, hi);
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);           // Sort left half.
        sort(a, mid + 1, hi);       // Sort right half.
        merge(a, lo, mid, hi);      // Merge results.
    }

    @SuppressWarnings("GrazieInspection")
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        StdOut.printf("merge(%d, %d, %d)%n", lo, mid, hi);
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
        Integer[] a;
        for (int N = 8; N <= 10; N++) {
            a = new Integer[N];
            for (int i = 0; i < N; i++) a[i] = StdRandom.uniform(0, 100);
            sort(a);
            StdOut.println();
        }
    }
}
