package com.claudhart.algs4.chapter2.section1.exercise19;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("DuplicatedCode")
public class ShellsortWorstCase {

    public static int comparesCnt;
    public static int maxCompares;

    public static <T extends Comparable<T>> void sort(T[] a) {
        comparesCnt = 0;
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }
        if (comparesCnt > maxCompares) maxCompares = comparesCnt;
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        comparesCnt += 1;
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // tag::include[]
    public static void main(String[] args) {
        final int SIZE = 100;
        final int TRAILS_NUM = 1_000_000;
        Integer[] a = new Integer[SIZE];
        for (int i = 0; i < a.length; ++i)
            a[i] = i + 1;
        for (int i = 0; i < TRAILS_NUM; ++i) {
            StdRandom.shuffle(a);
            sort(a);
        }
        StdOut.println("Max compares: " + maxCompares);
    }
    // end::include[]
}
