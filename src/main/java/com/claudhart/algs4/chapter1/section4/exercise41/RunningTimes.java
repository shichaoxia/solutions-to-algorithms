package com.claudhart.algs4.chapter1.section4.exercise41;

import com.claudhart.algs4.chapter1.section4.Stopwatch;
import com.claudhart.algs4.chapter1.section4.ThreeSum;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RunningTimes {
    @SuppressWarnings({"CommentedOutCode", "ResultOfMethodCallIgnored"})
    public static double timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
//        TwoSumFast.count(a);
//        TwoSum.count(a);
//        ThreeSumFast.count(a);
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; N <= 2000000; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %7.5f %5.1f\n", N, time, time / prev);
            prev = time;
        }
    }
}
