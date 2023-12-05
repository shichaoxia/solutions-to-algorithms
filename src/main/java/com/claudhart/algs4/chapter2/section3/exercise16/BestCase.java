package com.claudhart.algs4.chapter2.section3.exercise16;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class BestCase {
    // tag::snippet[]
    public static Integer[] bestCaseArray(int length) {
        Integer[] a = new Integer[length];

        for (int i = 0; i < length; i++) a[i] = i;

        bestCaseArray(a, 0, length - 1);
        return a;
    }

    public static void bestCaseArray(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        bestCaseArray(a, lo, mid - 1);
        bestCaseArray(a, mid + 1, hi);

        exch(a, lo, mid);
    }
    // end::snippet[]

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = bestCaseArray(10);
        StdOut.println(Arrays.toString(a));
    }
}
