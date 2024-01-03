package chapter2.section2.exercise6;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class MergeBU {
    public static int arrayAccessCount = 0;
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // Do lg N passes of pairwise merges.
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2)            // sz: subarray size
            for (int lo = 0; lo < N - sz; lo += 2 * sz)  // lo: subarray index
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
    }

    @SuppressWarnings("GrazieInspection")
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            set(aux, k, get(a, k));

        for (int k = lo; k <= hi; k++)           // Merge back to a[lo..hi].
            if (i > mid) set(a, k, get(aux, j++));    // left half exhausted (take from the right)
            else if (j > hi) set(a, k, get(aux, i++));   // right half exhausted (take from the left)
            else if (less(get(aux, j), get(aux, i))) set(a, k, get(aux, j++));
            else set(a, k, get(aux, i++));
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void set(Comparable[] a, int index, Comparable value) {
        arrayAccessCount += 1;
        a[index] = value;
    }

    public static Comparable get(Comparable[] a, int index) {
        arrayAccessCount += 1;
        return a[index];
    }

    
    public static int mergesortArrayOfLength(int length) {
        Double[] a = randomArray(length);
        MergeBU.sort(a);
        return MergeBU.arrayAccessCount;
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }
}
