package chapter2.section4.exercise16;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

@SuppressWarnings({"rawtypes"})
public class Heapsort {
    private static int compares = 0;

    public static int sort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 0; k--)
            sink(a, k, N);
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
        return resetCompares();
    }

    private static int resetCompares() {
        int temp = compares;
        compares = 0;
        return temp;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k + 1 <= N) {
            int j = 2 * k + 1;
            if (j < N && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable[] a, int i, int j) {
        compares++;
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
