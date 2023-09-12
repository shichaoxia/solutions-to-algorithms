package chapter3.section2.exercise13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void get() {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(5, 5);
        assertEquals(5, bst.get(5));
        bst.put(3, 3);
        assertEquals(3, bst.get(3));
        bst.put(7, 7);
        assertEquals(7, bst.get(7));
        bst.put(2, 2);
        assertEquals(2, bst.get(2));
    }
}