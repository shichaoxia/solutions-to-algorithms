package ch2.sec3.ex23;

import edu.princeton.cs.algs4.Insertion;
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
        int length = hi - lo + 1;
        if (length <= 10) {
            Insertion.sort(a, lo, hi + 1);
            return;
        } else {
            int m = medianOfNine(a, lo, hi);
            exch(a, lo, m);
        }
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

    // Divide the array into three secs, apply medianOfThree to each sec, and then apply medianOfThree to the three resulting values.
    private static int medianOfNine(Comparable[] a, int lo, int hi) {
        int oneThird = (hi - lo + 1) / 3;
        int twoThird = oneThird * 2;
        return medianOfThree(a, medianOfThree(a, lo, lo + oneThird),
                medianOfThree(a, lo + oneThird + 1, lo + twoThird),
                medianOfThree(a, lo + twoThird + 1, hi));
    }

    private static int medianOfThree(Comparable[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        return medianOfThree(a, lo, mid, hi);
    }

    private static int medianOfThree(Comparable[] a, int lo, int mid, int hi) {
        if (less(a[lo], a[mid])) {
            if (less(a[mid], a[hi])) return mid;
            else if (less(a[lo], a[hi])) return hi;
            else return lo;
        } else {
            if (less(a[lo], a[hi])) return lo;
            else if (less(a[mid], a[hi])) return hi;
            else return mid;
        }
    }
    // end::snippet[]

    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
