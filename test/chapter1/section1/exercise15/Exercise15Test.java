package chapter1.section1.exercise15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Exercise15Test {

    @Test
    void histogram() {
        int[] a = {1, 1, 1, 3, 3, 5};
        int[] expected = {0, 3, 0, 2, 0, 1};
        int[] result = Exercise15.histogram(a, 6);
        assertArrayEquals(expected, result);
    }
}
