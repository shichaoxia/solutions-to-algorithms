package chapter1.section3.Exercise39;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<Item> {
    private int N;
    private Item[] a;
    private int first = -1;  // -1 means empty
    private int last = -1;

    @SuppressWarnings("unchecked")
    public RingBuffer(int N) {
        this.N = N;
        a = (Item[]) new Object[N];
    }

    public boolean isEmpty() {
        return first == -1 && last == -1;
    }

    public void enqueue(Item item) {
        // Empty
        if (first == -1 && last == -1) {
            first = 0;
            last = 0;
            a[0] = item;
            return;
        }
        int newLast = (last + 1) % N;
        // Full
        if (newLast == first)
            return;
        a[newLast] = item;
        last = newLast;
    }

    public Item dequeue() {
        // Empty
        if (first == -1 && last == -1)
            return null;
        Item item = a[first];
        a[first] = null;
        // Last one
        if (first == last) {
            first = -1;
            last = -1;
        } else {
            first = (first + 1) % N;
        }
        return item;
    }

    public static void main(String[] args) {
        RingBuffer<String> b = new RingBuffer<>(5);
        b.enqueue("A");
        b.enqueue("B");
        b.enqueue("C");
        b.enqueue("D");
        b.enqueue("E");
        b.enqueue("F");
        StdOut.println(Arrays.toString(b.a));

        b.dequeue();
        b.dequeue();
        StdOut.println(Arrays.toString(b.a));
        b.enqueue("G");
        b.enqueue("H");
        StdOut.println(Arrays.toString(b.a));
    }

}
