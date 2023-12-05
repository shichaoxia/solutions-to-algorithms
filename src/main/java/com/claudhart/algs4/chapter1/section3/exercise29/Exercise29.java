package com.claudhart.algs4.chapter1.section3.exercise29;

import edu.princeton.cs.algs4.StdOut;

public class Exercise29 {
    public static class CircularLinkedList<Item> {
        private class Node {
            Item item;
            Node next;
        }

        private final Node last;
        private int N;

        public CircularLinkedList() {
            last = new Node();
            last.next = last;
        }

        public boolean isEmpty() {
            return last.next == last;
        }

        public int size() {
            return N;
        }

        public void addFirst(Item item) {
            Node first = last.next;
            Node newFirst = new Node();
            newFirst.item = item;
            newFirst.next = first;
            last.next = newFirst;
            N += 1;
        }

        public Item removeLast() {
            if (last.next == last)
                return null;
            Node first = last.next;
            Node second = first.next;
            if (second == last) {
                Item item = first.item;
                first.next = null;
                last.next = last;
                N -= 1;
                return item;
            }
            while (second.next != last) {
                first = second;
                second = second.next;
            }
            Item item = second.item;
            second.next = null;
            first.next = last;
            N -= 1;
            return item;
        }

        @Override
        public String toString() {
            String s = "";
            Node first = last.next;
            while (first != last) {
                s += ", " + first.item;
                first = first.next;
            }
            s = s.substring(2);
            return "CircularLinkedList [" + s + "](last) @" + System.identityHashCode(this);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> l = new CircularLinkedList<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        StdOut.println(l);
        l.removeLast();
        StdOut.println(l);
    }
}
