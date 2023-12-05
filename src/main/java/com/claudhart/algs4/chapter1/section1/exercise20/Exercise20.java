package com.claudhart.algs4.chapter1.section1.exercise20;

public class Exercise20 {
    public static double logFact(int N) {
        if (N == 1)
            return 0;
        return Math.log(N) + logFact(N - 1);
    }
}
