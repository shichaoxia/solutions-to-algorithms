package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise30 {
    public static class LinkedList<Item> {
        private class Node {
            Item item;
            Node next;
        }

        private Node first;

        public void addFirst(Item item) {
            Node newFirst = new Node();
            newFirst.item = item;
            newFirst.next = first;
            first = newFirst;
        }

        public void reverseI() {
            first = reverseIter(first);
        }

        public Node reverseIter(Node x) {
            Node backwardFirst = null;
            Node incoming = x;
            while (incoming != null) {
                Node forwardFirst = incoming.next;
                incoming.next = backwardFirst;
                backwardFirst = incoming;
                incoming = forwardFirst;
            }
            return backwardFirst;
        }

        public void reverseR() {
            first = reverseRecur(first);
        }

        private Node reverseRecur(Node first) {
            if (first == null)
                return null;
            if (first.next == null)
                return first;
            Node second = first.next;
            Node rest = reverseRecur(second);
            second.next = first;
            first.next = null;
            return rest;
        }

        @Override
        public String toString() {
            String s = "";
            Node current = first;
            while (current != null) {
                s += ", " + current.item;
                current = current.next;
            }
            s = s.substring(2);
            return "LinkedList (first)[" + s + "] @" + System.identityHashCode(this);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        l.addFirst("A");
        l.addFirst("B");
        l.addFirst("C");
        StdOut.println(l);
        l.reverseI();
        StdOut.println(l);
        l.reverseR();
        StdOut.println(l);
    }
}
