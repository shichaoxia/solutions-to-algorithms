package com.claudhart.algs4.chapter2.section2.exercise19;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy"})
public class Merge {

    private static int inversions;

    @SuppressWarnings("unused")
    public static int getInversions() {
        return inversions;
    }

    // tag::snippet[]
    public static int inversions(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        inversions = 0;
        inversions(a, aux, 0, a.length - 1);
        return inversions;
    }

    private static void inversions(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        inversions(a, aux, lo, mid);
        inversions(a, aux, mid + 1, hi);
        mergeAndCount(a, aux, lo, mid, hi);
    }

    public static void mergeAndCount(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                inversions += mid - i + 1;
            } else a[k] = aux[i++];
    }
    // end::snippet[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
