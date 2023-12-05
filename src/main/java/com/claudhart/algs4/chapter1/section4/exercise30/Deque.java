package com.claudhart.algs4.chapter1.section4.exercise30;

import com.claudhart.algs4.chapter1.section4.exercise29.Steque;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Stack;

public class Deque<Item> implements Iterable<Item> {

    int N = 0;
    Steque<Item> normal = new Steque<>();
    Stack<Item> inverse = new Stack<>();
    STATE state = STATE.NORMAL;

    public static void main(String[] args) {
        Deque<String> dq = new Deque<>();
        dq.addFirst("A");
        dq.addFirst("B");
        dq.addFirst("C");
        dq.addLast("D");
        dq.addLast("E");
        dq.addLast("F");
        for (String e : dq) StdOut.println(e);
        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeLast());
        for (String e : dq) StdOut.println(e);
        StdOut.println(dq.size());
        StdOut.println(dq.isEmpty());
    }

    public void addFirst(Item item) {
        ensure(STATE.NORMAL);
        N += 1;
        normal.push(item);
    }

    public Item removeFirst() {
        ensure(STATE.NORMAL);
        N -= 1;
        return normal.pop();
    }

    public void addLast(Item item) {
        ensure(STATE.NORMAL);
        N += 1;
        normal.enqueue(item);
    }

    public Item removeLast() {
        ensure(STATE.INVERSE);
        N -= 1;
        return inverse.pop();
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void ensure(Deque.STATE s) {
        if (s == Deque.STATE.NORMAL && state != Deque.STATE.NORMAL) {
            while (!inverse.isEmpty()) normal.push(inverse.pop());
            state = Deque.STATE.NORMAL;
        }
        if (s == Deque.STATE.INVERSE && state != Deque.STATE.INVERSE) {
            while (!normal.isEmpty()) inverse.push(normal.pop());
            state = Deque.STATE.INVERSE;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        ensure(STATE.NORMAL);
        return normal.iterator();
    }

    private enum STATE {
        NORMAL, INVERSE
    }
}
