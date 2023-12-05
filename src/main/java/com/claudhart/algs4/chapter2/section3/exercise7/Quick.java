package com.claudhart.algs4.chapter2.section3.exercise7;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick {
    private static Stat stat;

    public static void sort(Comparable[] a) {
        stat = new Stat();
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);

        if (j - lo >= 0) stat.add(j - lo);
        if (hi - j >= 0) stat.add(hi - j);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

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

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        List<Map<Comparable, Double>> maps;
        Integer[] a;
        StdOut.printf("%10s %10s %10s %10s%n", "N", "0", "1", "2");
        for (int N = 10; N <= 100_000; N *= 10) {
            a = new Integer[N];
            for (int i = 0; i < N; i++) a[i] = i;

            maps = new ArrayList<>();
            for (int T = 0; T < 1_000; T++) {
                sort(a);
                maps.add(stat.count);
            }
            Map<Comparable, Double> subMap = Stat.subFirst(Stat.getAvgMap(maps), 3);
            StdOut.printf("%10d %10.0f %10.0f %10.0f%n", N, subMap.get(0), subMap.get(1), subMap.get(2));
        }
    }
}
