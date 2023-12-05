package com.claudhart.algs4.chapter1.section3.exercise42;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;


public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public Stack() {
    }

    @SuppressWarnings("CopyConstructorMissesField")
    public Stack(Stack<Item> s) {
        Stack<Item> tmp = new Stack<>();
        for (Item item : s) {
            tmp.push(item);
        }
        for (Item item : tmp) {
            push(item);
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        StdOut.println("s: " + s);

        Stack<String> t = new Stack<>(s);
        s.pop();
        s.pop();
        StdOut.println("s: " + s);
        StdOut.println("t: " + t);
    }

    @SuppressWarnings("unused")
    public boolean isEmpty() {
        return first == null;
    }

    @SuppressWarnings("unused")
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

    @SuppressWarnings("UnusedReturnValue")
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @SuppressWarnings("unused")
    public Item peek() {
        return first.item;
    }

    @SuppressWarnings("DuplicatedCode")
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

    public @NotNull Iterator<Item> iterator() {
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
