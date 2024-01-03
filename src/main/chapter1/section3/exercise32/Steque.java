package chapter1.section3.exercise32;

import java.util.Iterator;

import chapter1.section3.exercise31.LinkedList;
import edu.princeton.cs.algs4.StdOut;


public class Steque<Item> implements Iterable<Item> {
    private final LinkedList<Item> l;

    public Steque() {
        l = new LinkedList<>();
    }

    public void push(Item item) {
        l.addFirst(item);
    }

    @SuppressWarnings("UnusedReturnValue")
    public Item pop() {
        return l.removeFirst();
    }

    public void enqueue(Item item) {
        l.addLast(item);
    }

    @Override
    public Iterator<Item> iterator() {
        return l.iterator();
    }

    @Override
    public String toString() {
        return l.toString();
    }

    public static void main(String[] args) {
        Steque<String> s = new Steque<>();
        s.push("A");
        s.push("B");
        s.enqueue("C");
        StdOut.println(s);
        s.pop();
        StdOut.println(s);
    }
}
