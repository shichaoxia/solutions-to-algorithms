package chapter2.section5.exercise27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionTest {

    @Test
    void indirectSort() {
        Integer[] a = {1, 2, 3, 4, 5};
        Integer[] index = Insertion.indirectSort(a);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, index);

        a = new Integer[]{5, 4, 3, 2, 1};
        index = Insertion.indirectSort(a);
        assertArrayEquals(new Integer[]{4, 3, 2, 1, 0}, index);
    }
}