package chapter2.section5.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void dedup() {
        String[] a = {"a", "a", "b", "b", "c", "c", "c"};
        String[] expected = {"a", "b", "c"};
        String[] actual = RemoveDuplicates.dedup(a);
        assertArrayEquals(expected, actual);
    }
}