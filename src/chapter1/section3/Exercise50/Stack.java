package chapter1.section3.exercise50;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("unused")
public class Stack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int N;
    private Node first;
    private int operationTimes;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
        operationTimes++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        operationTimes++;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.insert(0, current.item + " ");
            current = current.next;
        }
        s = new StringBuilder(s.toString().stripTrailing());
        return "Stack [" + s + "](top) @" + System.identityHashCode(this);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReversedIterator();
    }

    private class ReversedIterator implements Iterator<Item> {
        private Node current = first;
        private final int operatedTimes = operationTimes;

        @Override
        public boolean hasNext() {
            if (operatedTimes != operationTimes) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public Item next() {
            if (operatedTimes != operationTimes) {
                throw new ConcurrentModificationException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        StdOut.println(s);
        Iterator<String> i = s.iterator();
        i.next();
        s.push("D");
        i.next();
    }

}
