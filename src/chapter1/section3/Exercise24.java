package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24 {
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

        public void removeAfter(Node i) {
            if (i.next == null)
                return;
            i.next = i.next.next;
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
        StdOut.println("Remove after first item");
        LinkedList<String>.Node first = l.first;
        l.removeAfter(first);
        StdOut.println(l);
    }
}
