package ch2.sec1.ex17;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

@SuppressWarnings("DuplicatedCode")
public class Selection {
    private static final int ARRAY_SIZE = 20;
    private static final double RANDOM_LOWER_LIMIT = 0.0;
    private static final double RANDOM_UPPER_LIMIT = 20.0;
    private static final double HALF_BAR_WIDTH = 0.5;
    private static final long SLEEP_TIME = (long) 500.0;

    public static <T extends Comparable<T>> void sort(T[] a) throws InterruptedException {
        int N = a.length;
        setUpCanvas(N);
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            drawBars(a, i, min, false);
            exch(a, i, min);
            drawBars(a, i, min, true);
        }
    }

    public static <T extends Comparable<T>> void drawBars(T[] a, int examined, int min, boolean exchanged) throws InterruptedException {
        StdDraw.clear();
        for (int i = 0; i < a.length; ++i) {
            if (!exchanged) {
                if (i < examined) StdDraw.setPenColor(Color.gray);
                else if (i == min) StdDraw.setPenColor(Color.red);
                else if (i == examined) StdDraw.setPenColor(Color.blue);
                else StdDraw.setPenColor(Color.black);
            } else {
                if (i < examined) StdDraw.setPenColor(Color.gray);
                else if (i == examined) StdDraw.setPenColor(Color.red);
                else if (i == min) StdDraw.setPenColor(Color.blue);
                else StdDraw.setPenColor(Color.black);
            }
            StdDraw.filledRectangle(HALF_BAR_WIDTH + i, Double.parseDouble(a[i].toString()) / 2.0, HALF_BAR_WIDTH, Double.parseDouble(a[i].toString()) / 2.0);
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
