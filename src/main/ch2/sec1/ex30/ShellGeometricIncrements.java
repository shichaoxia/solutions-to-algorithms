package ch2.sec1.ex30;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ShellGeometricIncrements {

    public static void sort(Comparable[] a, int t) {
        int N = a.length;
        int h = 1;
        int index = 1;
        while (h < N / 3) h = generateT(t, ++index);
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = generateT(t, --index);
        }
    }

    public static int generateT(int t, int index) {
        if (index == 0)
            return 0;
        else
            return (int) Math.floor(Math.pow(t, index));
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    
    public static void show(Comparable[] a) {
        for (Comparable t : a) StdOut.print(t + " ");
        StdOut.println();
    }

    
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static double time(int t) {
        int N = 1_000_000;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Stopwatch timer = new Stopwatch();
        sort(a, t);
        return timer.elapsedTime();
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static void main(String[] args) {
        StdOut.printf("%6s %6s%n", "t", "time");
        List<Double> times = new ArrayList<>();
        int K = 300;
        for (int t = 2; t < K; t++) {
            double time = time(t);
            times.add(time);
            StdOut.printf("%6s %6.3f%n", t, time);
        }

        double maxY = 0.0;
        for (Double time : times)
            if (time > maxY) maxY = time;

        int T = times.size();
        StdDraw.setXscale(0, T);
        StdDraw.setYscale(0, maxY);
        double rectW = 1.0;
        for (int i = 0; i < T; i++) {
            double x = (i + 0.5) * rectW;
            double y = times.get(i) / 2.0;
            double halfW = rectW / 2.0;
            double halfH = y;
            StdDraw.filledRectangle(x, y, halfW, halfH);
        }

    }

}
