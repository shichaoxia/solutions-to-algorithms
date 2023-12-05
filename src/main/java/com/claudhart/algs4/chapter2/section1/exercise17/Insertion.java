package com.claudhart.algs4.chapter2.section1.exercise17;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

@SuppressWarnings("DuplicatedCode")
public class Insertion {

    private static final int ARRAY_SIZE = 20;
    private static final double RANDOM_LOWER_LIMIT = 0.0;
    private static final double RANDOM_UPPER_LIMIT = 20.0;
    private static final double HALF_BAR_WIDTH = 0.5;
    private static final long SLEEP_TIME = (long) 500.0;

    public static <T extends Comparable<T>> void sort(T[] a) throws InterruptedException {
        int N = a.length;
        setUpCanvas(N);
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                drawBars(a, i, j, false);
                exch(a, j, j - 1);
                drawBars(a, i, j, true);
            }
        }
    }

    public static <T extends Comparable<T>> void drawBars(T[] a, int i, int j, boolean exchanged) throws InterruptedException {
        StdDraw.clear();
        StdDraw.setPenColor(Color.black);
        for (int k = 0; k < a.length; ++k) {
            if (!exchanged) {
                if (k == j) StdDraw.setPenColor(Color.red);
                else if (k == j - 1) StdDraw.setPenColor(Color.blue);
                else if (k <= i) StdDraw.setPenColor(Color.black);
                else StdDraw.setPenColor(Color.gray);
            } else {
                if (k == j) StdDraw.setPenColor(Color.blue);
                else if (k == j - 1) StdDraw.setPenColor(Color.red);
                else if (k <= i) StdDraw.setPenColor(Color.black);
                else StdDraw.setPenColor(Color.gray);
            }
            StdDraw.filledRectangle(HALF_BAR_WIDTH + k, Double.parseDouble(a[k].toString()) / 2.0, HALF_BAR_WIDTH, Double.parseDouble(a[k].toString()) / 2.0);
        }
        Thread.sleep(SLEEP_TIME);
    }

    public static void setUpCanvas(int barsNum) {
        StdDraw.setXscale(0, barsNum);
        StdDraw.setYscale(RANDOM_LOWER_LIMIT, RANDOM_UPPER_LIMIT);
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T extends Comparable<T>> void show(T[] a) {
        for (T t : a) StdOut.print(t + " ");
        StdOut.println();
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Double[] a = new Double[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; ++i)
            a[i] = StdRandom.uniform(RANDOM_LOWER_LIMIT, RANDOM_UPPER_LIMIT);
        try {
            sort(a);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assert isSorted(a);
        show(a);
    }
}
