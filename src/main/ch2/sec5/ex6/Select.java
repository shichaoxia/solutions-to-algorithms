package ch2.sec5.ex6;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class Select {
    // tag::snippet[]
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        return select(a, k, lo, hi);
    }

    public static Comparable select(Comparable[] a, int k, int lo, int hi) {
        if (hi <= lo) return a[k];
        int j = partition(a, lo, hi);
        if (j == k) return a[k];
        else if (j > k) return select(a, k, lo, j - 1);
        else /* if (j < k) */ return select(a, k, j + 1, hi);
    }
    // end::snippet[]

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

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
