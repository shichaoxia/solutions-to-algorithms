package chapter2.section3.exercise4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Quick {

    private static int comparesNum;

    public static int sort(Comparable[] a) {
        comparesNum = 0;
        sort(a, 0, a.length - 1);
        return comparesNum;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        comparesNum += 1;
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int trialsNum = 10_000_000;
        Trial[] trials = new Trial[trialsNum];

        int len = 10;
        Integer[] a = new Integer[len];
        for (int i = 0; i < len; i++) a[i] = i;

        for (int i = 0; i < trialsNum; i++) {
            StdRandom.shuffle(a);
            String arrStr = Arrays.toString(a);
            int comparesNum = sort(a);
            trials[i] = new Trial(arrStr, comparesNum);
        }

        Arrays.sort(trials, Comparator.reverseOrder());
        for (int i = 0; i < 6; i++) StdOut.println(trials[i]);
    }

    private record Trial(String perm, double comparesNum) implements Comparable<Trial> {

        @Override
            public int compareTo(Quick.Trial o) {
                return Double.compare(comparesNum, o.comparesNum);
            }

            @Override
            public String toString() {
                return "Trial{" +
                        "perm='" + perm + '\'' +
                        ", comparesNum=" + comparesNum +
                        '}';
            }
        }

}
