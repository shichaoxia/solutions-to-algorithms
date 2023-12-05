package com.claudhart.algs4.chapter2.section3.exercise12;

import com.claudhart.algs4.chapter2.section3.PrintArrayAndIndices;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Quick3way {
    @SuppressWarnings("CommentedOutCode")
    public static void sort(Comparable[] a) {
        StdOut.printf("Sort: ");
        PrintArrayAndIndices.printArray(a);
//        StdOut.printf("%n");
//        StdRandom.shuffle(a);
//        StdOut.printf("Shuffled: ");
//        PrintArrayAndIndices.printArray(a);
        StdOut.printf("%n%n");
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        StdOut.printf("Sort %d, %d%n", lo, hi);
        if (hi <= lo) {
            StdOut.printf("hi <= lo%n%n", hi, lo);
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        PrintArrayAndIndices.print(a, lo, lt, i, gt, hi, "");
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                StdOut.printf("a[i](%s) is smaller than v(%s), exchange with a[lt](%s), forward lt and i%n", a[i].toString(), v.toString(), a[lt].toString());
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                StdOut.printf("a[i](%s) is larger than v(%s), exchange with a[gt](%s), backward gt%n", a[i].toString(), v.toString(), a[gt].toString());
                exch(a, i, gt--);
            } else {
                StdOut.printf("a[i](%s) is equal to v(%s), forward i%n", a[i].toString(), v.toString());
                i++;
            }
            PrintArrayAndIndices.print(a, lo, lt, i, gt, hi, "");
        } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        StdOut.printf("i > gt, trip end, ");
        StdOut.printf("-> sort(%d, %d) and sort(%d, %d)%n", lo, lt - 1, gt + 1, hi);
        StdOut.printf("%n%n");
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    @SuppressWarnings("unused")
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        String[] a = "B A B A B A B A C A D A B R A".split(" ");
        sort(a);
    }
}
