package chapter2.section2.exercise20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {

    @Test
    void sort() {
        Integer[] a = {4, 3, 5, 0, 2, 1};
        int[] perm = Merge.sort(a);
        assertArrayEquals(new int[]{3, 5, 4, 1, 0, 2}, perm);

        a = new Integer[]{1};
        perm = Merge.sort(a);
        assertArrayEquals(new int[]{0}, perm);

        a = new Integer[]{};
        perm = Merge.sort(a);
        assertArrayEquals(new int[]{}, perm);
    }
}