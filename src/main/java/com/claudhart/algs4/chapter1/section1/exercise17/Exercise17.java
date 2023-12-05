package com.claudhart.algs4.chapter1.section1.exercise17;

public class Exercise17 {
    @SuppressWarnings("unused")
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }
}
