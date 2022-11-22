package chapter1.section3.Exercise31;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList<Item> implements Iterable<Item> {
    private class DoubleNode {
        private Item item;
        private DoubleNode next;
        private DoubleNode pre;
    }

    private DoubleNode first;
    private DoubleNode last;
    private int N;

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        if (size() == 0) {
            addToEmpty(item);
            return;
        }
        insertBefore(first, item);
    }

    public void addLast(Item item) {
        if (size() == 0) {
            addToEmpty(item);
            return;
        }
        insertAfter(last, item);
    }

    public Item removeFirst() {
        if (size() == 0)
            return null;
        return remove(first);
    }

    public Item removeLast() {
        if (size() == 0)
            return null;
        return remove(last);
    }

    private void addToEmpty(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        first = newNode;
        last = newNode;
        N += 1;
    }

    private void connect(DoubleNode pre, DoubleNode node, DoubleNode next) {
        if (pre != null) {
            pre.next = node;
            node.pre = pre;
        }
        if (next != null) {
            node.next = next;
            next.pre = node;
        }
    }

    public void insertBefore(DoubleNode node, Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        N += 1;
        if (node == first) {
            connect(null, newNode, node);
            first = newNode;
            return;
        }
        connect(node.pre, newNode, node);
    }

    public void insertAfter(DoubleNode node, Item item) {
        if (node == last) {
            DoubleNode newNode = new DoubleNode();
            newNode.item = item;
            connect(node, newNode, null);
            last = newNode;
            N += 1;
            return;
        }
        insertBefore(node.next, item);
    }

    public Item remove(DoubleNode node) {
        N -= 1;
        Item item = node.item;
        if (node == first && node == last) {
            first = null;
            last = null;
            node.next = null;
            node.pre = null;
            return item;
        }
        if (node == first) {
            DoubleNode newFirst = first.next;
            first.next = null;
            newFirst.pre = null;
            first = newFirst;
            return item;
        }
        if (node == last) {
            DoubleNode newLast = last.pre;
            last.pre = null;
            newLast.next = null;
            last = newLast;
            return item;
        }
        DoubleNode pre = node.pre;
        DoubleNode next = node.next;
        node.next = null;
        node.pre = null;
        pre.next = next;
        next.pre = pre;
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        DoubleNode current = last;
        while (current != null) {
            s += " " + current.item;
            current = current.pre;
        }
        return s;
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.addFirst("A");
        StdOut.println(l);
        l.addLast("B");
        StdOut.println(l);
        l.insertAfter(l.first.next, "C");
        StdOut.println(l);
        l.insertBefore(l.first.next, "D");
        StdOut.println(l);
        l.remove(l.first.next);
        StdOut.println(l);
        l.removeFirst();
        StdOut.println(l);
        l.removeLast();
        StdOut.println(l);
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private DoubleNode current = last;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.pre;
            return item;
        }
    }

}
