package com.claudhart.algs4.chapter1.section4.exercise37;

import com.claudhart.algs4.chapter1.section3.FixedCapacityStack;
import com.claudhart.algs4.chapter1.section3.FixedCapacityStackOfInts;
import com.claudhart.algs4.chapter1.section4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {

    public static double timeTrialIntStack(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        FixedCapacityStackOfInts s = new FixedCapacityStackOfInts(N);
        for (int e : a) s.push(e);
        while (!s.isEmpty()) s.pop();
        return timer.elapsedTime();
    }

    public static double timeTrialIntegerStack(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        FixedCapacityStack<Integer> s = new FixedCapacityStack<>(N);
        for (int e : a) s.push(e);
        while (!s.isEmpty()) s.pop();
        return timer.elapsedTime();
    }


    public static void main(String[] args) {
        double intStackTime;
        double integerStackTime;
        for (int N = 250; true; N += N) {
            intStackTime = timeTrialIntStack(N);
            integerStackTime = timeTrialIntegerStack(N);
            StdOut.printf("%10d %7.6f %7.6f %5.1f%n", N, intStackTime, integerStackTime, integerStackTime / intStackTime);
        }
    }
}
