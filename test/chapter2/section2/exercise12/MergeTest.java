package chapter2.section2.exercise12;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    @Test
    void sort() {
        int N = 12;
        Integer[] a = new Integer[N];
        for (int j = 0; j < N; j++) a[j] = StdRandom.uniform(0, 100);
        Merge.sort(a, 3);
        assertTrue(Merge.isSorted(a));
    }

    @Test
    void merge() {
        Integer[] a = {9, 10, 11, 6, 7, 8, 3, 4, 5, 0, 1, 2};
        Integer[] aux = new Integer[3];
        Merge.merge(a, aux, 3, 5, 8);
        Integer[] expected = {9, 10, 11, 3, 4, 5, 6, 7, 8, 0, 1, 2};
        assertArrayEquals(expected, a);
    }

    @Test
    void sortBlock() {
        Integer[] a = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Merge.sortBlock(a, 0, 3);
        Merge.sortBlock(a, 1, 3);
        Merge.sortBlock(a, 3, 3);
        Integer[] expected = {9, 10, 11, 6, 7, 8, 5, 4, 3, 0, 1, 2};
        assertArrayEquals(expected,a);
    }
}