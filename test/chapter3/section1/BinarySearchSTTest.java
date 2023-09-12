package chapter3.section1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchSTTest {

    @Test
    void rank() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        assertEquals(0, st.rank(1));
        assertEquals(1, st.rank(2));
        assertEquals(2, st.rank(3));
        assertEquals(3, st.rank(4));
    }

    @Test
    void deleteMin() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        st.deleteMin();
        assertEquals(2, st.size());
        assertEquals(0, st.rank(1));
        assertEquals(0, st.rank(2));
        assertEquals(1, st.rank(3));
        assertEquals(2, st.rank(4));
    }

    @Test
    void deleteMax() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        st.deleteMax();
        assertEquals(2, st.size());
        assertEquals(0, st.rank(1));
        assertEquals(1, st.rank(2));
        assertEquals(2, st.rank(3));
        assertEquals(2, st.rank(4));
    }

    @Test
    void min() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        assertEquals(1, st.min());
    }

    @Test
    void max() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        assertEquals(3, st.max());
    }

    @Test
    void select() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        assertEquals(1, st.select(0));
        assertEquals(2, st.select(1));
        assertEquals(3, st.select(2));
    }

    @Test
    void floor() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        assertEquals(1, st.floor(1));
        assertEquals(2, st.floor(2));
        assertEquals(3, st.floor(3));
    }

    @Test
    void ceiling() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        assertEquals(1, st.ceiling(1));
        assertEquals(2, st.ceiling(2));
        assertEquals(3, st.ceiling(3));
    }

    @Test
    void keys() {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>();
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        int i = 1;
        for (Integer key : st.keys()) {
            assertEquals(i++, key);
        }
    }
}