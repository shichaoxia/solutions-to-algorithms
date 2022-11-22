package chapter1.section3;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    /**
     * @return From left to right is from the bottom to the top of the stack
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node current = first; current != null; current = current.next)
            s.insert(0, current.item + ", ");
        return s.substring(0, s.length() - 2);
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class Node {
        public Item item;
        public Node next;
    }

    private class ReverseIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
