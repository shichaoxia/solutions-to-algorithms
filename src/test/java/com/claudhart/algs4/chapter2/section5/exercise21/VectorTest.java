package com.claudhart.algs4.chapter2.section5.exercise21;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter2.section5.exercise21.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void compareTo() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(1, 2, 3);
        Vector v3 = new Vector(1, 2, 4);
        Vector v4 = new Vector(1, 3, 3);
        Vector v5 = new Vector(2, 2, 3);
        Vector v6 = new Vector(2, 3, 3);
        Vector v7 = new Vector(2, 3, 4);
        Vector v8 = new Vector(2, 4, 3);
        Vector v9 = new Vector(3, 2, 3);
        Vector v10 = new Vector(3, 2, 4);
        Vector v11 = new Vector(3, 3, 3);
        Vector v12 = new Vector(3, 3, 4);
        Vector v13 = new Vector(3, 4, 3);
        Vector v14 = new Vector(3, 4, 4);
        Vector v15 = new Vector(3, 4, 5);

        assertEquals(0, v1.compareTo(v2));
        assertEquals(-1, v1.compareTo(v3));
        assertEquals(-1, v1.compareTo(v4));
        assertEquals(-1, v1.compareTo(v5));
        assertEquals(-1, v1.compareTo(v6));
        assertEquals(-1, v1.compareTo(v7));
        assertEquals(-1, v1.compareTo(v8));
        assertEquals(-1, v1.compareTo(v9));
        assertEquals(-1, v1.compareTo(v10));
        assertEquals(-1, v1.compareTo(v11));
        assertEquals(-1, v1.compareTo(v12));
        assertEquals(-1, v1.compareTo(v13));
        assertEquals(-1, v1.compareTo(v14));
        assertEquals(-1, v1.compareTo(v15));

        assertEquals(1, v3.compareTo(v2));
        assertEquals(1, v4.compareTo(v2));
        assertEquals(1, v5.compareTo(v2));
        assertEquals(1, v6.compareTo(v2));
        assertEquals(1, v7.compareTo(v2));
        assertEquals(1, v8.compareTo(v2));
        assertEquals(1, v9.compareTo(v2));
        assertEquals(1, v10.compareTo(v2));
        assertEquals(1, v11.compareTo(v2));
    }
}