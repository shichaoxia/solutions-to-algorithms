package chapter2.section3.exercise3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode", "ClassEscapesDefinedScope"})
public class Quick {
    private static Integer largestExchNum;
    private static Comparable largest;
    private static String perm;

    public static void sort(Comparable[] a, Comparable largestItem) {
        largest = largestItem;
        largestExchNum = 0;
        StdRandom.shuffle(a);
        perm = Arrays.toString(a);
        sort(a, 0, a.length - 1);
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
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        if (i != j && (a[i] == largest || a[j] == largest))
            largestExchNum += 1;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static NumAndPerm trial(int length, int T) {
        Integer[] a = new Integer[length];
        for (int i = 0; i < length; i++) a[i] = i;
        int max = 0;
        String maxPerm = null;
        while (T-- > 0) {
            sort(a, length - 1);
            int currentExchNum = largestExchNum;
            if (currentExchNum > max) {
                max = currentExchNum;
                maxPerm = perm;
            }
        }
        return new NumAndPerm(max, maxPerm);
    }

    public static void main(String[] args) {
        StdOut.printf("%12s %12s %30s%n", "Array length", "Largest exch", "Perm");
        for (int length = 5; length <= 10; length++) {
            NumAndPerm values = trial(length, 1_000_000);
            int largest = values.num();
            String perm = values.perm();
            StdOut.printf("%12d %12d %30s%n", length, largest, perm);
        }
    }
}

record NumAndPerm(int num, String perm) {
}
