package chapter1.section1.exercise28;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Exercise28Test {
    @Test
    void testRemoveDuplicate() {
        int[] a = {1, 1, 1, 2, 2};
        int[] b = Exercise28.removeDuplicate(a);
        assertArrayEquals(new int[] {1, 2}, b);
    }
}
