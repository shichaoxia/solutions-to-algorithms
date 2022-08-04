package chapter1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercise29Test {
    @Test
    void testCount() {
        int[] a = {0, 1, 1, 1, 4, 4, 6};
        int c = Exercise29.rank(4, a);
        assertEquals(4, c);
    }

    @Test
    void testRank() {
        int[] a = {0, 1, 1, 1, 4, 4, 6};
        int c = Exercise29.count(1, a);
        assertEquals(3, c);
    }
}
