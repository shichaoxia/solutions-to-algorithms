package chapter2.section3.exercise5;

import chapter2.section3.PrintArrayAndIndices;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "DuplicatedCode", "unchecked"})
public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        StdOut.printf(">Sort %d, %d%n", lo, hi);
        if (hi <= lo) {
            StdOut.printf(">>%d <= %d, stop%n", hi, lo);
            StdOut.printf("%n");
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        StdOut.printf(">>Partition %d, %d%n", lo, hi);
        PrintArrayAndIndices.print(a, lo, hi, i, j, "initial");
        while (true) {
            StdOut.printf(">>>Left scan%n");
            while (less(a[++i], v)) {
                if (i == hi) {
                    PrintArrayAndIndices.print(a, lo, hi, i, j, "i == hi, break left scan");
                    break;
                } else {
                    PrintArrayAndIndices.print(a, lo, hi, i, j, a[i].toString() + " is ok");
                }
            }
            PrintArrayAndIndices.print(a, lo, hi, i, j, a[i].toString() + " is not smaller");
            StdOut.printf(">>>Right scan%n");
            while (less(v, a[--j])) {
                if (j == lo) {
                    PrintArrayAndIndices.print(a, lo, hi, i, j, "j == lo, break right scan");
                    break;
                } else {
                    PrintArrayAndIndices.print(a, lo, hi, i, j, a[j].toString() + " is ok");
                }
            }
            PrintArrayAndIndices.print(a, lo, hi, i, j, a[j].toString() + " is not bigger");
            if (i >= j) {
                PrintArrayAndIndices.print(a, lo, hi, i, j, "i >= j, break scan");
                break;
            }
            PrintArrayAndIndices.print(a, lo, hi, i, j, "Exchange a[i], a[j]");
            exch(a, i, j);
            PrintArrayAndIndices.print(a, lo, hi, i, j, "After exchange");
        }
        PrintArrayAndIndices.print(a, lo, hi, i, j, "Exchange a[lo], a[j]");
        exch(a, lo, j);
        PrintArrayAndIndices.print(a, lo, hi, i, j, "After exchange");
        StdOut.printf("j = %d%n", j);
        StdOut.printf("%n");
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Character[] a = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B'};
        sort(a);
    }
}
