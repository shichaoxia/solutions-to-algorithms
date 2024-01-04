package ch2.sec2.ex15;

import ch2.sec2.ex14.Merge;
import edu.princeton.cs.algs4.Queue;

public class BottomUpQueueMergesort {
    // tag::snippet[]
    @SuppressWarnings("rawtypes")
    public static Queue<Comparable> merge(Queue<Comparable> items) {
        Queue<Queue<Comparable>> queues = new Queue<>();
        for (Comparable i : items) {
            Queue<Comparable> q = new Queue<>();
            q.enqueue(i);
            queues.enqueue(q);
        }
        mergeQueues(queues);
        return queues.dequeue();
    }

    @SuppressWarnings("rawtypes")
    public static void mergeQueues(Queue<Queue<Comparable>> queues) {
        if (queues.size() == 1)
            return;
        queues.enqueue(Merge.merge(queues.dequeue(), queues.dequeue()));
        mergeQueues(queues);
    }
    // end::snippet[]
}
