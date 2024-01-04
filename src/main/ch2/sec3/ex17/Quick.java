package ch2.sec3.ex17;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Quick {
    // tag::snippet[]
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        exchangeLargestToRightmost(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
            }
            while (less(v, a[--j])) {
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exchangeLargestToRightmost(Comparable[] a) {
        if (a.length == 0) return;
        int largestIndex = getLargestItemIndex(a);
        exch(a, largestIndex, a.length - 1);
    }

    private static int getLargestItemIndex(Comparable[] a) {
        if (a.length == 0) return -1;
        Comparable largest = a[0];
        int largestIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (largest.compareTo(a[i]) < 0) {
                largest = a[i];
                largestIndex = i;
            }
        }
        return largestIndex;
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
        compareWithOriginal();
    }

    private static void compareWithOriginal() {
        StdOut.printf("%10s %10s %10s %10s%n", "N", "Sentinels", "Quick", "S/Q");
        for (int N = 1000; N <= 1_000_000; N += N) {
            Integer[] a = generateArray(N);
            double quicksortSentinelsTime = trial("quicksortSentinels", a);
            double quicksortTime = trial("quicksort", a);
            StdOut.printf("%10d %10.4f %10.4f %10.1f%n", N, quicksortSentinelsTime, quicksortTime, quicksortSentinelsTime / quicksortTime);
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
        if (alg.equals("quicksort")) ch2.sec3.Quick.sort(a);
        else if (alg.equals("quicksortSentinels")) sort(a);
        return s.elapsedTime();
    }

    private static Integer[] generateArray(int length) {
        Integer[] a = new Integer[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
