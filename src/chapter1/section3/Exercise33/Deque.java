package chapter1.section3.exercise33;

import java.util.Iterator;

import chapter1.section3.exercise31.LinkedList;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    private LinkedList<Item> l;

    public Deque() {
        l = new LinkedList<>();
    }

    public boolean isEmpty() {
        return l.size() == 0;
    }

    public int size() {
        return l.size();
    }

    public void pushLeft(Item item) {
        l.addLast(item);
    }

    public void pushRight(Item item) {
        l.addFirst(item);
    }

    public Item popLeft() {
        return l.removeLast();
    }

    public Item popRight() {
        return l.removeFirst();
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
        Deque<String> d = new Deque<>();
        d.pushLeft("A");
        d.pushLeft("B");
        d.pushLeft("C");
        StdOut.println(d);
        d.pushRight("D");
        StdOut.println(d);
        d.popLeft();
        StdOut.println(d);
        d.popRight();
        StdOut.println(d);
    }
}
