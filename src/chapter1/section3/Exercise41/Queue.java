package chapter1.section3.exercise41;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public Queue() {
    }

    @SuppressWarnings("CopyConstructorMissesField")
    public Queue(Queue<Item> q) {
        Queue<Item> tmp = new Queue<>();
        while (!q.isEmpty()) {
            Item item = q.dequeue();
            enqueue(item);
            tmp.enqueue(item);
        }
        while (!tmp.isEmpty())
            q.enqueue(tmp.dequeue());
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        StdOut.println("q: " + q);

        Queue<String> r = new Queue<>(q);
        StdOut.println("r: " + r);
        q.dequeue();
        q.dequeue();
        StdOut.println("q: " + q);
        StdOut.println("r: " + r);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String toString() {
        Node current = first;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(" ").append(current.item);
            current = current.next;
        }
        s = new StringBuilder(s.toString().stripLeading());
        return "Queue <[" + s + "]<@" + System.identityHashCode(this);
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
