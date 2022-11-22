package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise26 {
    public static <Item> void remove(LinkedList<Item> l, String key) {
        l.remove(key);
    }

    public static class LinkedList<Item> {
        class Node {
            Item item;
            Node next;
            Node pre;
        }

        private Node first;

        public void addFirst(Item i) {
            Node newFirst = new Node();
            newFirst.item = i;
            newFirst.next = first;
            if (first != null)
                first.pre = newFirst;
            first = newFirst;
        }

        public void remove(String key) {
            removeRecur(key, first);
        }

        private void removeRecur(String key, Node node) {
            if (node == null)
                return;

            // Save next node before the change
            Node n = node.next;

            if (node.item.equals(key)) {
                if (node.pre == null) {
                    // first
                    first = node.next;
                    node.next = null;
                } else if (node.next == null) {
                    // last
                    node.pre.next = null;
                    node.pre = null;
                } else {
                    // middle
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.pre = null;
                    node.next = null;
                }
            }
            removeRecur(key, n);
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
        l.addFirst("X");
        l.addFirst("A");
        l.addFirst("X");
        l.addFirst("B");
        l.addFirst("X");
        l.addFirst("C");
        l.addFirst("X");
        StdOut.println(l);
        StdOut.println("Remove X");
        remove(l, "X");
        StdOut.println(l);
    }
}
