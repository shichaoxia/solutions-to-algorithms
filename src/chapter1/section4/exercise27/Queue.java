package chapter1.section4.exercise27;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    int N = 0;
    Stack<Item> enqueueStack = new Stack<>();
    Stack<Item> dequeueStack = new Stack<>();
    STATE state = STATE.ENQUEUE;

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        for (String e : q) StdOut.println(e);
        StdOut.println(q.dequeue());
        StdOut.println(q.isEmpty());
        StdOut.println(q.size());
        for (String e : q) StdOut.println(e);
    }

    void enqueue(Item item) {
        ensure(STATE.ENQUEUE);
        N += 1;
        enqueueStack.push(item);
    }

    Item dequeue() {
        ensure(STATE.DEQUEUE);
        N -= 1;
        return dequeueStack.pop();
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        ensure(STATE.DEQUEUE);
        return dequeueStack.iterator();
    }

    private void ensure(STATE s) {
        if (s == STATE.ENQUEUE && state != STATE.ENQUEUE) {
            while (!dequeueStack.isEmpty()) enqueueStack.push(dequeueStack.pop());
            state = STATE.ENQUEUE;
        }

        if (s == STATE.DEQUEUE && state != STATE.DEQUEUE) {
            while (!enqueueStack.isEmpty()) dequeueStack.push(enqueueStack.pop());
            state = STATE.DEQUEUE;
        }
    }

    private enum STATE {
        ENQUEUE, DEQUEUE
    }
}
