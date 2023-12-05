package com.claudhart.algs4.chapter1.section1;

@SuppressWarnings("unused")
public class Accumulator {
    private double total;
    private int N;

    @SuppressWarnings("unused")
    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }
}
