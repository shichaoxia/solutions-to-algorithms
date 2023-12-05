package com.claudhart.algs4.chapter1.section1.exercise36;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise36Test {
    static int M = 4;
    static int N = 1000000;

    @Test
    void testShuffleStats() {
        double expected = N / M;
        int[][] stats = Exercise36.shuffleStats(M, N, StdRandom::shuffle);
        for (int[] row : stats) {
            for (int item : row) {
                double variation = Math.abs(expected - item);
                assertTrue(variation / expected < 0.01);
            }
        }
    }

    @Test
    void showShuffleStats() {
        int[][] stats = Exercise36.shuffleStats(M, N, StdRandom::shuffle);
        for (int[] row : stats) {
            System.out.println(Arrays.toString(row));
        }
    }
}
