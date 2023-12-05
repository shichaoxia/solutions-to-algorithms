package com.claudhart.algs4.chapter2.section3.exercise26;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick {

    public static Map<Integer, Integer> countMap;

    public static void sort(Comparable[] a, int cutoff) {
        countMap = new TreeMap<>();
        StdRandom.shuffle(a);
        sort(a, cutoff, 0, a.length - 1);
    }

    // tag::snippet[]
    private static void sort(Comparable[] a, int cutoff, int lo, int hi) {
        int length = hi - lo + 1;
        if (length <= 1) {
            return;
        } else if (length <= cutoff) {
            count(length);
            Insertion.sort(a, lo, hi + 1);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, cutoff, lo, j - 1);
        sort(a, cutoff, j + 1, hi);
    }
    // end::snippet[]

    private static int partition(Comparable[] a, int lo, int hi) {
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

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @SuppressWarnings("unused")
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    // Count the number of occurrences for each length and store the statistical data in countMap.
    private static void count(int length) {
        if (countMap.containsKey(length)) {
            countMap.put(length, countMap.get(length) + 1);
        } else {
            countMap.put(length, 1);
        }
    }
}
