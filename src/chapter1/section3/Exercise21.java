package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise21 {
    public static <Item> boolean find(LinkedList<Item> l, String key) {
        return l.find(key);
    }

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
        StdOut.printf("Find B: %s%n", find(l, "B"));
        StdOut.printf("Find Z: %s%n", find(l, "Z"));
    }
}
