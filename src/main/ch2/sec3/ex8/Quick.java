package ch2.sec3.ex8;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick {

    private static int comparesNum;

    public static int sort(Comparable[] a) {
        comparesNum = 0;
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        return comparesNum;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
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
        comparesNum += 1;
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int T = 100;
        StdOut.printf("%10s %10s %10s %10s%n", "N", "Equal", "Distinct", "2NlnN");
        for (int N = 1_000; N <= 100_000; N += N) {
            int avgComparesNum = trialEqual(N, T);
            int avgComparesNum2 = trialDistinct(N, T);
            StdOut.printf("%10d %10d %10d %10.0f%n", N, avgComparesNum, avgComparesNum2, 2 * N * Math.log(N));
        }
    }

    private static int trialEqual(int N, int T) {
        int totalComparesNum = 0;

        Integer[] a = new Integer[N];
        Arrays.fill(a, 0);

        for (int i = 0; i < T; i++) {
            int comparesNum = sort(a);
            totalComparesNum += comparesNum;
        }

        return totalComparesNum / T;
    }

    private static int trialDistinct(int N, int T) {
        int totalComparesNum = 0;

        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) a[i] = i;

        for (int i = 0; i < T; i++) {
            int comparesNum = sort(a);
            totalComparesNum += comparesNum;
        }

        return totalComparesNum / T;
    }


}
