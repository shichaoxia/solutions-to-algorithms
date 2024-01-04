package ch2.sec1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {

    @SuppressWarnings("GrazieInspection")
    public static <T extends Comparable<T>> void sort(T[] a) {
        // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++) {
            // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of minimal entr.
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T extends Comparable<T>> void show(T[] a) {
        for (T t : a) StdOut.print(t + " ");
        StdOut.println();
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = (new In()).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
