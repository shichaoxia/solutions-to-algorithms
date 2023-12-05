package com.claudhart.algs4.chapter2.section3.exercise27;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickTest {
    private static Integer[] generateArray(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(1_000);
        }
        return a;
    }

    @Test
    void sort() {
        int cutoff, length, trials = 1_000;
        Integer[] a;
        for (int i = 0; i < trials; i++) {
            length = StdRandom.uniform(1, 1_000);
            cutoff = StdRandom.uniform(0, 31);
            a = generateArray(length);
            Quick.sort(a, cutoff);
            assertTrue(Quick.isSorted(a));
        }
    }
}