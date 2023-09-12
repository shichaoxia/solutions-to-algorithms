package chapter2.section2.exercise19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    @Test
    void sort() {
        Character[] a = {'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        assertEquals(11, Merge.inversions(a));
    }

    @Test
    void merge() {
        Integer[] a = {2, 4, 8, 1, 3, 9};
        Integer[] aux = new Integer[a.length];
        Merge.mergeAndCount(a, aux, 0, 2, 5);
        assertEquals(5, Merge.getInversions());
    }
}