package com.claudhart.algs4.chapter1.section1.exercise32;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Exercise32 {
    public static int[] histogram(double[] samples, int N, double l, double r) {
        double interval = (r - l) / N;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            for (double item : samples) {
                if ((l + i * interval <= item) && (item < l + (i + 1) * interval))
                    nums[i] += 1;
            }
        }
        return nums;
    }

    public static void drawHistogram(int[] a) {
        double w = 1.0 / a.length;
        double gap = 0.05;
        for (int i = 0; i < a.length; i++) {
            double x = w * (i + 0.5);
            double y = a[i] / 2.0 / 10;
            double rw = w / 2 - gap;
            double rh = a[i] / 2.0 / 10;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double[] samples = StdIn.readAllDoubles();
        int[] h = histogram(samples, N, l, r);
        drawHistogram(h);
    }
}
