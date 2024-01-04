package ch2.sec3.ex18;

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
        medianOfThree(a, lo, hi);
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

    private static void medianOfThree(Comparable[] a, int lo, int hi) {
        if (hi - lo + 1 < 3) return;
        int mid = (lo + hi) / 2;
        int secondMaxIndex = findSecondMax(a[lo], lo, a[mid], mid, a[hi], hi);
        exch(a, lo, secondMaxIndex);
    }

    // Compare three items a, b, c and return the index of the second-largest item.
    private static int findSecondMax(Comparable a, int aIndex, Comparable b, int bIndex, Comparable c, int cIndex) {
        if (less(a, b)) {
            if (less(b, c)) return bIndex;
            else if (less(a, c)) return cIndex;
            else return aIndex;
        } else {
            if (less(a, c)) return aIndex;
            else if (less(b, c)) return cIndex;
            else return bIndex;
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
        StdOut.printf("%10s %10s %10s %10s%n", "N", "MedianOfThree", "Quick", "M/Q");
        for (int N = 1000; N <= 1_000_000; N += N) {
            Integer[] a = generateArray(N);
            double medianOfThreeTime = trial("medianOfThree", a);
            double quicksortTime = trial("quicksort", a);
            StdOut.printf("%10d %10.4f %10.4f %10.1f%n", N, medianOfThreeTime, quicksortTime, medianOfThreeTime / quicksortTime);
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
        else if (alg.equals("medianOfThree")) sort(a);
        return s.elapsedTime();
    }

    private static Integer[] generateArray(int length) {
        Integer[] a = new Integer[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
