package com.claudhart.algs4.chapter2.section3.exercise20;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick {
    // tag::snippet[]
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        Stack<Subarray> stack = new Stack<>();
        List<Comparable> result = new ArrayList<>();
        stack.push(new Subarray(a, 0, a.length - 1));
        while (!stack.isEmpty()) {
            Subarray subarray = stack.pop();
            sort(stack, result, subarray.a, subarray.lo, subarray.hi);
        }
        for (int i = 0; i < a.length; i++)
            a[i] = result.get(i);
    }

    private static void sort(Stack<Subarray> sorting, List<Comparable> result, Comparable[] a, int lo, int hi) {
        if (hi < lo) return;
        if (hi == lo) {
            result.add(a[hi]);
            return;
        }
        int j = partition(a, lo, hi);
        sorting.push(new Subarray(a, lo, j - 1));
        sorting.push(new Subarray(a, j, j));
        sorting.push(new Subarray(a, j + 1, hi));
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
    // end::snippet[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        doublingRatio();
        compareWithOriginal();
    }

    private static void doublingRatio() {
        StdOut.printf("Doubling ratio test:%n");
        StdOut.printf("%10s %10s %10s%n", "N", "time", "log ratio");
        int N = 500;
        Comparable[] a = generateArray(N);
        double previous = trial("nonrecursive", a);
        for (N = 1_000; N <= 1_000_000; N += N) {
            a = generateArray(N);
            double time = trial("nonrecursive", a);
            StdOut.printf("%10d %10.3f %10.1f%n", N, time, Math.log(time / previous) / Math.log(2));
            previous = time;
        }
    }

    private static void compareWithOriginal() {
        StdOut.printf("%nCompare with original quick sort:%n");
        StdOut.printf("%10s %10s %10s %10s%n", "N", "nonrecursive", "quick", "nr/quick");
        for (int N = 1000; N < 1_000_000; N += N) {
            Comparable[] a = generateArray(N);
            double nonrecursive = trial("nonrecursive", a);
            double quick = trial("quick", a);
            StdOut.printf("%10d %10.3f %10.3f %10.3f%n", N, nonrecursive, quick, nonrecursive / quick);
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
            case "quick" -> com.claudhart.algs4.chapter2.section3.Quick.sort(a);
            case "nonrecursive" -> sort(a);
        }
        return s.elapsedTime();
    }

    private static Comparable[] generateArray(int length) {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }

    private record Subarray(Comparable[] a, int lo, int hi) {
    }
}
