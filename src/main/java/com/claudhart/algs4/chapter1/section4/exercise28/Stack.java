package com.claudhart.algs4.chapter1.section4.exercise28;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    int N = 0;
    final Queue<Item> q = new Queue<>();

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        for (String e : s) StdOut.println(e);
        StdOut.println(s.pop());
        StdOut.println(s.isEmpty());
        StdOut.println(s.size());
        for (String e : s) StdOut.println(e);
    }

    void push(Item item) {
        N += 1;
        q.enqueue(item);
    }

    Item pop() {
        for (int i = N - 1; i > 0; i--)
            q.enqueue(q.dequeue());
        N -= 1;
        return q.dequeue();
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    @Override
    public @NotNull Iterator<Item> iterator() {
        return q.iterator();
    }
}
