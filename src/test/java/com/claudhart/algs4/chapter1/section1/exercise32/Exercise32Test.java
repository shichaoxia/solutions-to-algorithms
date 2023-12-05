package com.claudhart.algs4.chapter1.section1.exercise32;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Exercise32Test {
    @Test
    void testHistogram() {
        double[] a = {1.0, 1.1, 1.3, 2.5, 2.6, 2.7, 2.9, 3.1, 3.5, 3.8, 4.7, 5.0};
        int[] b = Exercise32.histogram(a, 3, 0.5, 6.0);
        System.out.println(Arrays.toString(b));
    }
}
