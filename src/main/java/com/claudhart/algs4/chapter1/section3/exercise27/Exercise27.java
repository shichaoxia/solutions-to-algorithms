package com.claudhart.algs4.chapter1.section3.exercise27;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("DuplicatedCode")
public class Exercise27 {

    public static int max(Node node) {
        int max = 0;
        while (node != null) {
            if (node.item > max)
                max = node.item;
            node = node.next;
        }
        return max;
    }

    @SuppressWarnings("DuplicatedCode")
    public static class LinkedList {

        private Node first;

        public void addFirst(Integer i) {
            Node newFirst = new Node();
            newFirst.item = i;
            newFirst.next = first;
            first = newFirst;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            Node i = first;
            while (i != null) {
                s.insert(0, i.item + " ");
                i = i.next;
            }
            s = new StringBuilder(s.toString().stripTrailing());
            return "LinkedList [" + s + "](first)@" + System.identityHashCode(this);
        }
    }

    public static class Node {
        Integer item;
        Node next;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addFirst(8);
        l.addFirst(5);
        l.addFirst(7);
        l.addFirst(9);
        l.addFirst(2);
        l.addFirst(4);
        StdOut.println(l);
        StdOut.println("Max item: " + max(l.first));
    }
}
