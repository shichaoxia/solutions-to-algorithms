package com.claudhart.algs4.chapter2.section1.exercise32;

import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlotRunningTimes {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total / T;
    }

    public static void main(String[] args) {
        int N = 20_000;
        int T = 1;
        List<Double> selectionTimes = new ArrayList<>();
        List<Double> insertionTimes = new ArrayList<>();
        List<Double> shellTimes = new ArrayList<>();
        int step = 100;
        for (int i = step; i < N; i += step) {
            double selectionTime = timeRandomInput("Selection", i, T);
            double insertionTime = timeRandomInput("Insertion", i, T);
            double shellTime = timeRandomInput("Shell", i, T);
            selectionTimes.add(selectionTime);
            insertionTimes.add(insertionTime);
            shellTimes.add(shellTime);
        }
        draw(selectionTimes,Color.BLUE);
        draw(insertionTimes,Color.RED);
        draw(shellTimes,Color.BLACK);

    }

    public static void draw(List<Double> a, Color c) {
        double maxY = Collections.max(a);
        StdDraw.setPenColor(c);
        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(0, a.size());
        StdDraw.setYscale(0, maxY);
        for (int i = 0; i < a.size(); i++) StdDraw.point(i, a.get(i));
    }

}
