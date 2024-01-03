package chapter2.section2.exercise11;

import chapter2.section2.Merge;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Merge3 {

    // tag::solution[]
    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(a, aux, 0, a.length - 1);
        System.arraycopy(aux, 0, a, 0, a.length);
    }

    private static void sort(Comparable[] src, Comparable[] dest, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        sort(dest, src, low, mid);
        sort(dest, src, mid + 1, high);

        merge(src, dest, low, mid, high);
    }

    private static void merge(Comparable[] src, Comparable[] dest, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                dest[k] = src[j++];
            } else if (j > high) {
                dest[k] = src[i++];
            } else if (less(src[j], src[i])) {
                dest[k] = src[j++];
            } else {
                dest[k] = src[i++];
            }
        }
    }
    // end::solution[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        StdOut.printf("%10s %10s %10s %10s%n", "N", "Time", "Original", "Ratio");
        for (int N = 5_000; N <= 500_000; N += N) {
            double time = time(randomArray(N), 10);
            double originalTime = originalTime(randomArray(N), 10);
            StdOut.printf("%10d %10.3f %10.3f %10.1f%n", N, time, originalTime, time / originalTime);
        }
    }

    public static double time(Double[] a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            sort(a);
            time += sw.elapsedTime();
        }
        return time / T;
    }

    public static double originalTime(Double[] a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            Merge.sort(a);
            time += sw.elapsedTime();
        }
        return time / T;
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++)
            a[i] = StdRandom.uniform();
        return a;
    }
}
