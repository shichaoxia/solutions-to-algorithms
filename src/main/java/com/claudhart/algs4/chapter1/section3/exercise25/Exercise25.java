package com.claudhart.algs4.chapter1.section3.exercise25;

import edu.princeton.cs.algs4.StdOut;

public class Exercise25 {
    public static class LinkedList<Item> {
        public class Node {
            public Item item;
            public Node next;
        }

        public Node first;

        public void addFirst(Item i) {
            Node newFirst = new Node();
            newFirst.item = i;
            newFirst.next = first;
            first = newFirst;
        }

        public void insertAfter(Node anchor, Node el) {
            if (anchor == null || el == null)
                return;
            el.next = anchor.next;
            anchor.next = el;
        }

        @Override
        public String toString() {
            String s = "";
            Node i = first;
            while (i != null) {
                s = i.item + " " + s;
                i = i.next;
            }
            s = s.stripTrailing();
            return "LinkedList [" + s + "](first)@" + System.identityHashCode(this);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.addFirst("A");
        l.addFirst("B");
        l.addFirst("C");
        StdOut.println(l);
        LinkedList<String>.Node el = l.new Node();
        el.item = "X";
        LinkedList<String>.Node anchor = l.first.next;
        l.insertAfter(anchor, el);
        StdOut.println(l);
    }
}
