package chapter1.section3.Exercise47;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public void catenation(Queue<Item> q) {
        last.next = q.first;
        last = q.last;
        N += q.size();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
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

    @Override
    public String toString() {
        Node current = first;
        String s = "";
        while (current != null) {
            s += " " + current.item;
            current = current.next;
        }
        s = s.stripLeading();
        return "Queue <[" + s + "]<@" + System.identityHashCode(this);
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
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

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        StdOut.println(q);
        Queue<String> r = new Queue<>();
        r.enqueue("X");
        r.enqueue("Y");
        r.enqueue("Z");
        StdOut.println(r);
        q.catenation(r);
        StdOut.println(q);
    }
}
