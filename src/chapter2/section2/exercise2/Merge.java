package chapter2.section2.exercise2;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
public class Merge {

    private static Comparable[] aux;  // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];  // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        StdOut.printf("sort(%d, %d)%n", lo, hi);
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);           // Sort left half.
        sort(a, mid + 1, hi);       // Sort right half.
        merge(a, lo, mid, hi);      // Merge results.
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        StdOut.printf("merge(%d, %d, %d)%n", lo, mid, hi);
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)           // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];        // left half exhausted (take from the right)
            else if (j > hi) a[k] = aux[i++];    // right half exhausted (take from the left)
            else if (less(aux[j], aux[i])) a[k] = aux[j++];  // right is smaller (take from right)
            else a[k] = aux[i++];                            // take from left
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        String[] a = "EASYQUESTION".split("");
        sort(a);
    }
}

