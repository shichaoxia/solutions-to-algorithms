package com.claudhart.algs4.chapter1.section3;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

@SuppressWarnings("unused")
public class Bag<Item> implements Iterable<Item> {

    private Node first;

    @SuppressWarnings("unused")
    private class Node {
        Item item;
        Node next;
    }

    @SuppressWarnings("unused")
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public @NotNull Iterator<Item> iterator() {
        return new ListIterator();
    }

    @SuppressWarnings("unused")
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
