package chapter2.section2.exercise9;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    boolean isSorted(Double[] a) {
        Double previous = a[0];
        for (int i = 1; i < a.length; i++) {
            if (previous > a[i]) return false;
            previous = a[i];
        }
        return true;
    }

    @Test
    void sort() {
        int N = 100;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();
        Double[] aux = new Double[N];
        Merge.sort(a, aux);
        assertTrue(isSorted(a));
    }
}