package ch2.sec2.ex14;

import edu.princeton.cs.algs4.Queue;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Merge {

    // tag::snippet[]

    /**
     * Assume that the elements dequeue first are smaller.
     */
    public static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b) {
        Queue<Comparable> c = new Queue<>();
        for (int i = a.size() + b.size(); i > 0; --i) {
            if (a.isEmpty()) c.enqueue(b.dequeue());
            else if (b.isEmpty()) c.enqueue(a.dequeue());
            else if (less(b.peek(), a.peek())) c.enqueue(b.dequeue());
            else c.enqueue(a.dequeue());
        }
        return c;
    }
    // end::snippet[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
