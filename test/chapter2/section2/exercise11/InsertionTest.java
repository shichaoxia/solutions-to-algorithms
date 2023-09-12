package chapter2.section2.exercise11;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionTest {

    @Test
    void sort() {
        int N = 100;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();
        int lo = 10;
        int hi = 80;
        Insertion.sort(a, lo, hi);
        assertTrue(Insertion.isSorted(a, lo, hi));
    }
}