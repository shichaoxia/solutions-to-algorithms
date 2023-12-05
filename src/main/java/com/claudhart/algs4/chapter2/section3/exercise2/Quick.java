package com.claudhart.algs4.chapter2.section3.exercise2;

import com.claudhart.algs4.chapter2.section3.PrintArrayAndIndices;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({"rawtypes", "DuplicatedCode", "unchecked"})
public class Quick {

    private static Map<Comparable, Integer> exchStat;

    public static void sort(Comparable[] a) {
        exchStat = new HashMap<>();
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // StdOut.printf(">Sort %d, %d%n", lo, hi);
        if (hi <= lo) {
            // StdOut.printf(">>%d <= %d, stop%n", lo, hi);
            // StdOut.printf("%n");
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        // StdOut.printf(">>Partition %d, %d%n", lo, hi);
        //PrintArrayAndIndices.print(a, lo, hi, i, j, "initial");
        while (true) {
            // StdOut.printf(">>>Left scan%n");
            while (less(a[++i], v)) {
                if (i == hi) {
                    //PrintArrayAndIndices.print(a, lo, hi, i, j, "i == hi, break left scan");
                    break;
                } else {
                    //PrintArrayAndIndices.print(a, lo, hi, i, j, a[i].toString() + " is ok");
                }
            }
            //PrintArrayAndIndices.print(a, lo, hi, i, j, a[i].toString() + " is bigger");
            // StdOut.printf(">>>Right scan%n");
            while (less(v, a[--j])) {
                if (j == lo) {
                    //PrintArrayAndIndices.print(a, lo, hi, i, j, "j == lo, break right scan");
                    break;
                } else {
                    //PrintArrayAndIndices.print(a, lo, hi, i, j, a[j].toString() + " is ok");
                }
            }
            //PrintArrayAndIndices.print(a, lo, hi, i, j, a[j].toString() + " is smaller");
            if (i >= j) {
                //PrintArrayAndIndices.print(a, lo, hi, i, j, "i >= j, break scan");
                break;
            }
            //PrintArrayAndIndices.print(a, lo, hi, i, j, "Exchange a[i], a[j]");
            exch(a, i, j);
            //PrintArrayAndIndices.print(a, lo, hi, i, j, "After exchange");
        }
        //PrintArrayAndIndices.print(a, lo, hi, i, j, "Exchange a[lo], a[j]");
        exch(a, lo, j);
        //PrintArrayAndIndices.print(a, lo, hi, i, j, "After exchange");
        // StdOut.printf("j = %d%n", j);
        // StdOut.printf("%n");
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        stat(a[i]);
        stat(a[j]);
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void stat(Comparable i) {
        if (exchStat.containsKey(i)) {
            exchStat.put(i, exchStat.get(i) + 1);
        } else {
            exchStat.put(i, 0);
        }
    }

    public static Map.Entry<Comparable, Integer> findMaxEntry(Map<Comparable, Integer> map) {
        Map.Entry<Comparable, Integer> maxEntry = null;

        for (Map.Entry<Comparable, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }


    public static void main(String[] args) {
        Character[] a = {'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        for (int i = 0; i < 100; i++) {
            StdRandom.shuffle(a);
            sort(a);
            Map.Entry<Comparable, Integer> maxEntry = findMaxEntry(exchStat);
            System.out.println("Maximum value is " + maxEntry.getValue() + " for key " + maxEntry.getKey());
        }
    }
}
