package com.claudhart.algs4.chapter2.section1.exercise11;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Shell {
    // tag::sort[]
    public static <T extends Comparable<T>> void sort(T[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        Stack<Integer> incrementSequence = new Stack<>();
        incrementSequence.push(h);
        while (h < N / 3) { // 1, 4, 13, 40, 121, 364, 1093, ...
            h = 3 * h + 1;
            incrementSequence.push(h);
        }
        for (h = incrementSequence.pop(); !incrementSequence.isEmpty(); h = incrementSequence.pop()) {
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
        }
    }
    // end::sort[]

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T extends Comparable<T>> void show(T[] a) {
        for (T t : a) StdOut.print(t + " ");
        StdOut.println();
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = (new In()).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
