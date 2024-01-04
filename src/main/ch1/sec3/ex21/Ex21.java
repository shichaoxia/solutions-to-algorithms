package ch1.sec3.ex21;

import edu.princeton.cs.algs4.StdOut;

public class Ex21 {
    public static <Item> boolean find(LinkedList<Item> l, String key) {
        return l.find(key);
    }

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

        public boolean find(String key) {
            Node i = first;
            while (i != null) {
                if (i.item.equals(key))
                    return true;
                i = i.next;
            }
            return false;
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
        l.addFirst("A");
        l.addFirst("B");
        l.addFirst("C");
        StdOut.println(l);
        StdOut.printf("Find B: %s%n", find(l, "B"));
        StdOut.printf("Find Z: %s%n", find(l, "Z"));
    }
}
