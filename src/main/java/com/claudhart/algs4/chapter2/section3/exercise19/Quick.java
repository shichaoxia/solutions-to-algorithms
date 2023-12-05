package com.claudhart.algs4.chapter2.section3.exercise19;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick {

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

    // tag::snippet[]
    private static int partition(Comparable[] a, int lo, int hi) {
        medianOfFive(a, lo, hi);
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void medianOfFive(Comparable[] a, int lo, int hi) {
        if (hi - lo + 1 < 5) return;
        int mid = (lo + hi) / 2;
        int midL = (lo + mid) / 2;
        int midR = (mid + hi) / 2;
        int thirdMaxIndex = findThirdMax(a[lo], lo, a[midL], midL, a[mid], mid, a[midR], midR, a[hi], hi);
        exch(a, lo, thirdMaxIndex);
    }

    // Compare five items a, b, c, d, e and return the index of the third-largest item.
    private static int findThirdMax(Comparable a, int aIndex, Comparable b, int bIndex, Comparable c, int cIndex, Comparable d, int dIndex, Comparable e, int eIndex) {
        if (less(a, b)) {
            if (less(b, c)) {
                if (less(c, d)) {
                    if (less(d, e)) return eIndex;
                    else return dIndex;
                } else {
                    if (less(c, e)) return eIndex;
                    else return cIndex;
                }
            } else {
                if (less(b, d)) {
                    if (less(d, e)) return eIndex;
                    else return dIndex;
                } else {
                    if (less(b, e)) return eIndex;
                    else return bIndex;
                }
            }
        } else {
            if (less(a, c)) {
                if (less(c, d)) {
                    if (less(d, e)) return eIndex;
                    else return dIndex;
                } else {
                    if (less(c, e)) return eIndex;
                    else return cIndex;
                }
            } else {
                if (less(a, d)) {
                    if (less(d, e)) return eIndex;
                    else return dIndex;
                } else {
                    if (less(a, e)) return eIndex;
                    else return aIndex;
                }
            }
        }
    }
    // end::snippet[]

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        compareWithOriginal();
    }

    private static void compareWithOriginal() {
        StdOut.printf("%10s %10s %10s %10s %10s %10s%n", "N", "Five", "Three", "Quick", "Five/Three", "Five/Q");
        for (int N = 1000; N <= 1_000_000; N += N) {
            Integer[] a = generateArray(N);
            double medianOfFiveTime = trial("medianOfFive", a);
            double medianOfThreeTime = trial("medianOfThree", a);
            double quicksortTime = trial("quicksort", a);
            StdOut.printf("%10d %10.4f %10.4f %10.4f %10.2f %10.2f%n", N, medianOfFiveTime, medianOfThreeTime, quicksortTime, medianOfFiveTime / medianOfThreeTime, medianOfFiveTime / quicksortTime);
        }
    }

    private static double trial(String alg, Comparable[] a) {
        int T = 10;
        double totalTime = 0.0;
        for (int i = 0; i < T; i++) {
            totalTime += time(alg, a);
        }
        return totalTime / 10;
    }

    private static double time(String alg, Comparable[] a) {
        Stopwatch s = new Stopwatch();
        switch (alg) {
            case "quicksort" -> com.claudhart.algs4.chapter2.section3.Quick.sort(a);
            case "medianOfThree" -> com.claudhart.algs4.chapter2.section3.exercise18.Quick.sort(a);
            case "medianOfFive" -> sort(a);
        }
        return s.elapsedTime();
    }

    private static Integer[] generateArray(int length) {
        Integer[] a = new Integer[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
