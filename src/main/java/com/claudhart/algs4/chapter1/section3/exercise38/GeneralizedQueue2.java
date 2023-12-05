package com.claudhart.algs4.chapter1.section3.exercise38;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("UnusedReturnValue")
public class GeneralizedQueue2<Item> {

    private final LinkedList<Item> l = new LinkedList<>();

    @SuppressWarnings("unused")
    public boolean isEmpty() {
        return l.size() == 0;
    }

    public void insert(Item x) {
        l.addLast(x);
    }

    public Item delete(int k) {
        DoubleNode<Item> node = l.first;
        while (k > 0) {
            node = node.next;
            k -= 1;
        }
        return l.remove(node);
    }

    public static void main(String[] args) {
        GeneralizedQueue2<String> q = new GeneralizedQueue2<>();
        q.insert("A");
        q.insert("B");
        q.insert("C");
        q.insert("D");
        q.insert("E");
        StdOut.println(q.l);
        q.delete(0);
        q.delete(1);
        q.delete(2);
        StdOut.println(q.l);
    }

}
