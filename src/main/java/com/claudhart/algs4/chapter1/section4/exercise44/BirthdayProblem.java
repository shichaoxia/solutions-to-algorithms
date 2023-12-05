package com.claudhart.algs4.chapter1.section4.exercise44;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

public class BirthdayProblem {

    public static int numbersBeforeRepeated(int N) {
        Set<Integer> s = new HashSet<>();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            int item = StdRandom.uniform(N);
            a[i] = item;
            if (s.contains(item)) return i;
            else s.add(item);
        }
        return -1;
    }

    public static void main(String[] args) {
        StdOut.printf("%7s %6s %6s%n", "N", "Actual", "Sim");
        for (int N = 125; N < 1_000_000; N += N)
            StdOut.printf("%7d %6d %6.0f%n", N, numbersBeforeRepeated(N), Math.sqrt(Math.PI * N / 2));
    }
}
