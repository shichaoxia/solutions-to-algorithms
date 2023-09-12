package chapter2.section2.exercise10;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    @Test
    void sort() {
        Double[] a = new Double[100];
        for (int i = 0; i < 100; i++) a[i] = StdRandom.uniform();
        Merge.sort(a);
        assertTrue(Merge.isSorted(a));
    }
}