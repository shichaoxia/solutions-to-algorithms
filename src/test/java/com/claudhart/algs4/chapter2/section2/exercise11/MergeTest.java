package com.claudhart.algs4.chapter2.section2.exercise11;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    @Test
    void sort() {
        for (int i = 0; i < 10; i++) {
            int N = StdRandom.uniform(1, 100);
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            Merge.sort(a);
            assertTrue(Merge.isSorted(a));
        }
    }
}