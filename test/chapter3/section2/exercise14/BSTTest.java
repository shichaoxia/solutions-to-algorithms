package chapter3.section2.exercise14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void min() {
        BST<Integer, Integer> bst = new BST<>();
        Arrays.stream(new int[]{2, 4, 6, 8, 10, 12, 14}).forEach(i -> bst.put(i, i));

        assertEquals(2, bst.min());

        assertEquals(14, bst.max());

        assertNull(bst.floor(0));
        assertEquals(2, bst.floor(2));
        assertEquals(2, bst.floor(3));
        assertEquals(4, bst.floor(4));
        assertEquals(14, bst.floor(15));

        assertEquals(2, bst.ceiling(1));
        assertEquals(2, bst.ceiling(2));
        assertEquals(4, bst.ceiling(3));
        assertNull(bst.ceiling(15));

        assertEquals(0,bst.rank(1));
        assertEquals(0, bst.rank(2));
        assertEquals(1, bst.rank(4));
        assertEquals(2, bst.rank(6));
        assertEquals(6, bst.rank(14));
        assertEquals(7, bst.rank(15));

        assertEquals(2, bst.select(0));
        assertEquals(4, bst.select(1));
        assertEquals(6, bst.select(2));
        assertEquals(14, bst.select(6));
    }
}