package com.claudhart.algs4.chapter1.section4.exercise22;

public class FibonacciSearch {
    public static int search(int key, int[] a) {
        int N = a.length;
        if (N == 0) return -1;

        int fKm2 = 0;
        int fKm1 = 1;
        int fK = fKm2 + fKm1;

        /* Find the fibonacci number greater than and closest to N */
        while (fK < N) {
            fKm2 = fKm1;
            fKm1 = fK;
            fK = fKm2 + fKm1;
        }

        return search(key, a, 0, N - 1, fKm2, fKm1);
    }

    public static int search(int key, int[] a,
                             int lo, int hi,
                             int fKm2, int fKm1) {
        if (lo == hi)
            return a[lo] == key ? lo : -1;

        /* search smaller part */
        if (a[lo + fKm2] > key)
            return search(key, a,
                    lo, lo + fKm2 - 1,
                    fKm2 - (fKm1 - fKm2), fKm1 - fKm2);

        /* search larger part */
        if (a[lo + fKm2] < key)
            return search(key, a,
                    lo + fKm2, Math.min(lo + fKm2 + fKm1 - 1, hi),
                    fKm1 - fKm2, fKm2);

        return lo + fKm2;
    }
}
