package com.claudhart.algs4.chapter2.section1.exercise25;

@SuppressWarnings({"rawtypes", "unchecked"})
public class InsertionWithoutExchanges {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int j = i;
            while (j > 0 && less(a[i], a[j - 1])) --j;
            if (j != i) {
                Comparable temp = a[i];
                moveToRightOnePosition(a, j, i - 1);
                a[j] = temp;
            }
        }
    }

    public static void moveToRightOnePosition(Comparable[] a, int start, int end) {
        for (int i = end; i >= start; --i) {
            a[i + 1] = a[i];
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

}
