package chapter2.section1.exercise24;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InsertionSentinelTest {

    @Test
    void sort() {
        int N = StdRandom.uniform(10, 100);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        InsertionSentinel.sort(a);
        assertTrue(InsertionSentinel.isSorted(a));

    }
}