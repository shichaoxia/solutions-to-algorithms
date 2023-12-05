package com.claudhart.algs4.chapter2.section2.exercise6;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Merge {

    public static int arrayAccessCount = 0;
    public static Comparable[] aux;  // auxiliary array for merges

    public static void sort(Comparable[] a) {
        arrayAccessCount = 0;
        aux = new Comparable[a.length];  // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);           // Sort left half.
        sort(a, mid + 1, hi);       // Sort right half.
        merge(a, lo, mid, hi);      // Merge results.
    }

    @SuppressWarnings("GrazieInspection")
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            set(aux, k, get(a, k));

        for (int k = lo; k <= hi; k++)           // Merge back to a[lo..hi].
            if (i > mid) set(a, k, get(aux, j++));        // left half exhausted (take from the right)
            else if (j > hi) set(a, k, get(aux, i++));    // right half exhausted (take from the left)
            else if (less(get(aux, j), get(aux, i))) set(a, k, get(aux, j++));
            else set(a, k, get(aux, i++));
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void set(Comparable[] a, int index, Comparable value) {
        arrayAccessCount += 1;
        a[index] = value;
    }

    public static Comparable get(Comparable[] a, int index) {
        arrayAccessCount += 1;
        return a[index];
    }

    public static void plotPoints(double[] a) {
        for (int i = 0; i < a.length; i++) StdDraw.point(i, a[i]);
    }

    public static int mergesortArrayOfLength(int length) {
        Double[] a = randomArray(length);
        Merge.sort(a);
        return Merge.arrayAccessCount;
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }

    public static double upperBoundFunc(double N) {
        return 6 * N * (Math.log(N) / Math.log(2));
    }

    public static double max(double[] a) {
        double max = a[0];
        for (double item : a) if (item > max) max = item;
        return max;
    }

    public static void main(String[] args) {
        int N = 513;
        double[] numsOfAccesses = new double[N];
        for (int i = 1; i < N; i++)
            numsOfAccesses[i] = mergesortArrayOfLength(i);

        double[] numsOfAccessesBu = new double[N];
        for (int i = 1; i < N; i++)
            numsOfAccessesBu[i] = Merge.mergesortArrayOfLength(i);

        double[] uppers = new double[N];
        for (int i = 1; i < N; i++)
            uppers[i] = upperBoundFunc(i);

        StdDraw.setXscale(0.0, N);
        StdDraw.setYscale(0.0, Math.max(Math.max(max(numsOfAccesses), max(numsOfAccessesBu)), max(uppers)));
        plotPoints(numsOfAccesses);
        StdDraw.setPenColor(Color.BLUE);
        plotPoints(numsOfAccessesBu);
        StdDraw.setPenColor(Color.RED);
        plotPoints(uppers);
    }
}
