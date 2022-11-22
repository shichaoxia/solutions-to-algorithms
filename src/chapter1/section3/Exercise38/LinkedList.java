package chapter1.section3.Exercise38;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList<Item> implements Iterable<Item> {

    public DoubleNode<Item> first;
    public DoubleNode<Item> last;
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
        DoubleNode<Item> newNode = new DoubleNode<Item>();
        newNode.item = item;
        first = newNode;
        last = newNode;
        N += 1;
    }

    private void connect(DoubleNode<Item> pre, DoubleNode<Item> node, DoubleNode<Item> next) {
        if (pre != null) {
            pre.next = node;
            node.pre = pre;
        }
        if (next != null) {
            node.next = next;
            next.pre = node;
        }
    }

    public void insertBefore(DoubleNode<Item> node, Item item) {
        DoubleNode<Item> newNode = new DoubleNode<Item>();
        newNode.item = item;
        N += 1;
        if (node == first) {
            connect(null, newNode, node);
            first = newNode;
            return;
        }
        connect(node.pre, newNode, node);
    }

    public void insertAfter(DoubleNode<Item> node, Item item) {
        if (node == last) {
            DoubleNode<Item> newNode = new DoubleNode<Item>();
            newNode.item = item;
            connect(node, newNode, null);
            last = newNode;
            N += 1;
            return;
        }
        insertBefore(node.next, item);
    }

    public Item remove(DoubleNode<Item> node) {
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
            DoubleNode<Item> newFirst = first.next;
            first.next = null;
            newFirst.pre = null;
            first = newFirst;
            return item;
        }
        if (node == last) {
            DoubleNode<Item> newLast = last.pre;
            last.pre = null;
            newLast.next = null;
            last = newLast;
            return item;
        }
        DoubleNode<Item> pre = node.pre;
        DoubleNode<Item> next = node.next;
        node.next = null;
        node.pre = null;
        pre.next = next;
        next.pre = pre;
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        DoubleNode<Item> current = first;
        while (current != null) {
            s += " " + current.item;
            current = current.next;
        }
        s = s.trim();
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
        private DoubleNode<Item> current = last;

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
