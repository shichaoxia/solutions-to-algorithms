package ch2.sec3.ex22;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // tag::snippet[]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int p = lo, i = lo + 1, j = hi, q = hi + 1;
        Comparable v = a[lo];
        int cmpI, cmpJ;
        while (true) {
            while (i <= hi) {
                cmpI = a[i].compareTo(v);
                if (cmpI == 0) exch(a, i++, ++p);
                else if (cmpI > 0) break;
                else i++;
            }
            while (j > lo && j >= i) {
                cmpJ = a[j].compareTo(v);
                if (cmpJ == 0) exch(a, j--, --q);
                else if (cmpJ < 0) break;
                else j--;
            }
            if (j < i) break;
            exch(a, i++, j--);
        }
        // Swap the items with equal keys into position
        int m = lo;
        int n = hi;
        while (j > p && m <= p) exch(a, m++, j--);
        while (i < q && n >= q) exch(a, i++, n--);

        // Sort the subarrays
        if (m > p) sort(a, lo, j);  // <v items are more than equal keys
        else sort(a, lo, m - 1);
        if (n < q) sort(a, i, hi);
        else sort(a, n + 1, hi);
    }
    // end::snippet[]

    
    // private static boolean less(Comparable v, Comparable w) {
    //     return v.compareTo(w) < 0;
    // }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
