package com.claudhart.algs4.chapter2.section4.exercise40;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class HeapsortZero {

    private static int comparesNum = 0;

    public static int sort(Comparable[] a) {
        comparesNum = 0;
        int N = a.length - 1;
        for (int k = (N - 1) / 2; k >= 0; k--)
            sink(a, k, N);
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
        return comparesNum;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k + 1 <= N) {
            int j = 2 * k + 1;
            if (j + 1 <= N && less(a, j, j + 1)) j += 1;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable[] a, int i, int j) {
        comparesNum++;
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
