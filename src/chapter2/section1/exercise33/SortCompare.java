package chapter2.section1.exercise33;

import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCompare {
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

    public static double timeRandomInput(String alg, int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        return time(alg, a);

    }

    public static void main(String[] args) {
        String alg = args[0];
        int T = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);
        List<Double> times = new ArrayList<>();
        List<Double> avgTimes = new ArrayList<>();
        for (int i = 0; i < T; ++i) {
            double time = timeRandomInput(alg, N);
            times.add(time);
            addAvgTime(times, avgTimes, time);
        }
        draw(times, Color.BLACK);
        draw(avgTimes, Color.BLUE);
    }

    public static void addAvgTime(List<Double> times, List<Double> avgTimes, double t) {
        Double sum = 0.0;
        for (double x : times)
            sum += x;
        Double newAvg = (sum + t) / (times.size() + 1);
        avgTimes.add(newAvg);
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
