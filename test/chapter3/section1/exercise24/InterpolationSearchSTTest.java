package chapter3.section1.exercise24;

import chapter3.section1.OrderedST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpolationSearchSTTest {

    @Test
    void rank() {
        OrderedST<Integer, String> st = new InterpolationSearchST<>();
        st.put(1, "One");
        st.put(2, "Two");
        st.put(3, "Three");
        st.put(4, "Four");
        assertEquals(0, st.rank(1));
        assertEquals(1, st.rank(2));
        assertEquals(2, st.rank(3));
        assertEquals(3, st.rank(4));
        assertEquals(0, st.rank(0));
        assertEquals(4, st.rank(5));
    }
}