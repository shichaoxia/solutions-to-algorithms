package com.claudhart.algs4.chapter1.section4.exercise42;

import com.claudhart.algs4.chapter1.section4.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"DuplicatedCode", "InfiniteLoopStatement"})
public class ProblemSizes {
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
        double prev = timeTrial(1000);
        for (int P = 1; true; ++P) {
            int N = (int) Math.pow(2, P) * 1000;
            double time = timeTrial(N);
            StdOut.printf("%6d %10d %7.1f ", P, N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
