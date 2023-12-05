package com.claudhart.algs4.chapter2.section5.exercise27;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    // tag::snippet[]
    public static Integer[] indirectSort(Comparable[] a) {
        int N = a.length;
        Integer[] index = new Integer[N];
        for (int i = 0; i < N; i++) index[i] = i;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
                exch(index, j, j - 1);
        }

        return index;
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
}
