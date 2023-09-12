package chapter3.section2.exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTConstTest {

    @Test
    void height() {
        BSTConst<Integer, Integer> bst = new BSTConst<>();
        bst.put(3, 3);
        assertEquals(0, bst.height());
        bst.put(4, 4);
        assertEquals(1, bst.height());
        bst.put(1, 1);
        assertEquals(1, bst.height());
        bst.put(5, 5);
        assertEquals(2, bst.height());
        bst.put(2, 2);
        assertEquals(2, bst.height());
    }
}