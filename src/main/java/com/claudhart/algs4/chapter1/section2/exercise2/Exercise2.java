package com.claudhart.algs4.chapter1.section2.exercise2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] endpoints = new double[2 * N];
        for (int i = 0; i < endpoints.length; i++) {
            endpoints[i] = StdIn.readDouble();
        }

        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < endpoints.length; i += 2) {
            intervals[i / 2] = new Interval1D(endpoints[i], endpoints[i + 1]);
        }
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j]))
                    StdOut.printf("%s intersects with %s%n", intervals[i], intervals[j]);
            }
        }
    }
}
