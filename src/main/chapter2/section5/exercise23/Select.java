package chapter2.section5.exercise23;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class Select {

    // tag::snippet[]
    static final int SAMPLES_NUM = 5;

    @SuppressWarnings("UnusedReturnValue")
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        double r = (double) k / a.length;
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi, r);
            if (j == k) return a[k];
            else if (j > k) hi = j - 1;
            else /* if (j < k) */ lo = j + 1;
        }
        return a[k];
    }

    public static void select(String alg, Comparable[] a, int k) {
        switch (alg) {
            case "select" -> select(a, k);
            case "original" -> chapter2.section5.Select.select(a, k);
            default -> throw new IllegalStateException("Unexpected value: " + alg);
        }
    }

    public static double trial(String alg, Comparable[] a, int k) {
        Stopwatch timer = new Stopwatch();
        select(alg, a, k);
        return timer.elapsedTime();
    }
    // end::snippet[]

    public static void main(String[] args) {
        System.out.printf("%10s %10s %10s\n", "N\\time/alg", "Select", "Original");
        Integer[] a;
        for (int N = 10_000; N <= 100_000_000; N *= 10) {
            a = generateRandomArray(N);
            double selectTime = trial("select", a, N / 3);
            double originalTime = trial("original", a, N / 3);
            System.out.printf("%10d %10.3f %10.3f\n", N, selectTime, originalTime);
        }
    }

    public static Integer[] generateRandomArray(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(N);
        }
        return a;
    }

    private static int partition(Comparable[] a, int lo, int hi, double r) {
        int i = lo, j = hi + 1;
        int pivot = sample(a, lo, hi, SAMPLES_NUM, r);
        exch(a, lo, pivot);
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

    public static int sample(Comparable[] a, int lo, int hi, int M, double r) {
        Entry[] entries = new Entry[M];
        for (int i = 0; i < M; i++) {
            int index = StdRandom.uniform(lo, hi + 1);
            entries[i] = new Entry(a[index], index);
        }
        Arrays.sort(entries);
        return entries[(int) (entries.length * r)].index;
    }

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @SuppressWarnings("unchecked")
    record Entry(Comparable value, int index) implements Comparable<Entry> {

        @Override
            public int compareTo(Select.Entry o) {
                return this.value.compareTo(o.value);
            }
        }

}
