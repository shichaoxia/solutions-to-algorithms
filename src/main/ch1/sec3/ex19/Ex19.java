package ch1.sec3.ex19;

import edu.princeton.cs.algs4.StdOut;

public class Ex19 {

    @SuppressWarnings("DuplicatedCode")
    public static class LinkedList<Item> {
        private class Node {
            Item item;
            Node next;
        }

        private Node first;

        public void addFirst(Item i) {
            Node newFirst = new Node();
            newFirst.item = i;
            newFirst.next = first;
            first = newFirst;
        }

        @SuppressWarnings("UnusedReturnValue")
        public Item removeLast() {
            if (first == null)
                return null;
            if (first.next == null) {
                Item item = first.item;
                first = null;
                return item;
            }
            Node a = first;
            Node b = first.next;
            while (b.next != null) {
                a = a.next;
                b = b.next;
            }
            Item item = b.item;
            a.next = null;
            return item;
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

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        StdOut.printf("Add first A, ");
        l.addFirst("A");
        StdOut.println(l);
        StdOut.printf("Add first B, ");
        l.addFirst("B");
        StdOut.println(l);
        StdOut.printf("Remove last, ");
        l.removeLast();
        StdOut.println(l);
        StdOut.printf("Remove last, ");
        l.removeLast();
        StdOut.println(l);
    }
}
