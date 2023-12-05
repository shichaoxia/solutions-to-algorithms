package com.claudhart.algs4.chapter2.section1.exercise26;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InsertionPrimitiveTest {

    @Test
    void sort() {

        int N = StdRandom.uniform(10, 100);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        InsertionPrimitive.sort(a);
        assertTrue(InsertionPrimitive.isSorted(a));

    }
}