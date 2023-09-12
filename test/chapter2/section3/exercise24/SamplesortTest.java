package chapter2.section3.exercise24;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SamplesortTest {

    @Test
    void sort() {
        int lengthLimit = 1_000;
        int length;
        int trailsNum = 1_000;
        Integer[] a;
        Integer[] b;
        for (int i = 0; i < trailsNum; i++) {
            length = StdRandom.uniform(1, lengthLimit);
            a = new Integer[length];
            for (int j = 0; j < length; j++) a[j] = j;
            b = a.clone();
            Samplesort.sort(a);
            assertArrayEquals(b, a);
        }
    }
}