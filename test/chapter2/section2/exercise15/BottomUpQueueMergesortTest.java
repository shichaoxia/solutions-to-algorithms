package chapter2.section2.exercise15;

import edu.princeton.cs.algs4.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("rawtypes")
class BottomUpQueueMergesortTest {

    @Test
    void merge() {
        Queue<Comparable> a = new Queue<>();
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(2);
        a.enqueue(1);
        a.enqueue(0);
        Queue<Comparable> b = BottomUpQueueMergesort.merge(a);
        for (int i = 0; i < 5; i++) {
            assertEquals(i, b.dequeue());
        }
    }
}