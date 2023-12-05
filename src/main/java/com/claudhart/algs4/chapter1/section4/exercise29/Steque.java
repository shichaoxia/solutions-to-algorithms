package com.claudhart.algs4.chapter1.section4.exercise29;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {

    private final Stack<Item> normalStack = new Stack<>();
    private final Stack<Item> inverseStack = new Stack<>();
    STATE state = STATE.NORMAL;
    private int N = 0;

    public static void main(String[] args) {
        Steque<String> sq = new Steque<>();
        sq.push("A");
        sq.push("B");
        sq.push("C");
        sq.enqueue("D");
        for (String e : sq) StdOut.println(e);
        StdOut.println(sq.pop());
        StdOut.println(sq.isEmpty());
        StdOut.println(sq.size());
        for (String e : sq) StdOut.println(e);
    }

    public void push(Item item) {
        ensure(STATE.NORMAL);
        normalStack.push(item);
        N += 1;
    }

    public Item pop() {
        ensure(STATE.NORMAL);
        N -= 1;
        return normalStack.pop();
    }

    public void enqueue(Item item) {
        ensure(STATE.INVERSE);
        inverseStack.push(item);
        N += 1;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        ensure(STATE.INVERSE);
        return inverseStack.iterator();
    }

    private void ensure(STATE s) {
        if (s == STATE.NORMAL && state != STATE.NORMAL) {
            while (!inverseStack.isEmpty()) normalStack.push(inverseStack.pop());
            state = STATE.NORMAL;
        }
        if (s == STATE.INVERSE && state != STATE.INVERSE) {
            while (!normalStack.isEmpty()) inverseStack.push(normalStack.pop());
            state = STATE.INVERSE;
        }
    }

    private enum STATE {
        NORMAL, INVERSE
    }
}
