package com.claudhart.algs4.chapter2.section2.exercise14;

import edu.princeton.cs.algs4.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("rawtypes")
class MergeTest {

    @Test
    void merge() {
        Queue<Comparable> a = new Queue<>();
        a.enqueue(0);
        a.enqueue(2);
        a.enqueue(4);
        Queue<Comparable> b = new Queue<>();
        b.enqueue(1);
        b.enqueue(3);
        b.enqueue(5);
        Queue<Comparable> c = Merge.merge(a, b);
        for (int i = 0; i <= 5; i++) {
            assertEquals(i, c.dequeue());
        }
    }
}