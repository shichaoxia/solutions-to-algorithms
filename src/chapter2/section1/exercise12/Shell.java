package chapter2.section1.exercise12;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Shell {

    private static int compareCnt = 0;

    public static <T extends Comparable<T>> void sort(T[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) {
            StdOut.printf("%10d ", N);
            StdOut.printf("%10d ", h);
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            StdOut.printf("%10d ", compareCnt);
            StdOut.printf("%13f%n", compareCnt / (double) N);
            compareCnt = 0;
            h = h / 3;
        }
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        compareCnt += 1;
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        StdOut.printf("%10s %10s %10s %13s%n", "Size", "h", "Compares", "Compares/Size");
        for (int size = 100; size <= 10_000; size *= 10) {
            Double[] arr = new Double[size];
            for (int i = 0; i < size; ++i)
                arr[i] = StdRandom.uniform(1_000_000) / 1000.0;
            sort(arr);
        }
    }

}
