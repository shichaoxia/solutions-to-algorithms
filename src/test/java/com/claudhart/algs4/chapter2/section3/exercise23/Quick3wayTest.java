package com.claudhart.algs4.chapter2.section3.exercise23;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Quick3wayTest {

    @Test
    void sort() {
        int len = 30;
        int trailsNum = 1_000;
        Integer[] a = new Integer[len];
        for (int i = 0; i < len; i++) a[i] = i;
//        Integer[] b = new Integer[len];
//        for (int i = 0; i < len; i++) b[i] = i;
//        for (int i = 0; i < trailsNum; i++) {
//            Quick3way.sort(a);
//            assertArrayEquals(b, a);
//        }
        Quick3way.sort(a);
        StdOut.println(Arrays.toString(a));

    }
}