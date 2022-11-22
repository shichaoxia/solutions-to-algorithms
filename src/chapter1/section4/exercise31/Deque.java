package chapter1.section4.exercise31;

import java.util.Iterator;
import java.util.Stack;

public class Deque<Item> implements Iterable<Item> {

    int N = 0;
    Stack<Item> forward = new Stack<>();
    Stack<Item> backward = new Stack<>();
    Stack<Item> temp = new Stack<>();

    public void addFirst(Item item) {
        N += 1;
        forward.push(item);
    }

    public Item removeFirst() {
        if (forward.isEmpty() && backward.isEmpty()) return null;
        else if (forward.isEmpty()) balanceTo(backward, forward);
        N -= 1;
        return forward.pop();
    }

    public void addLast(Item item) {
        N += 1;
        backward.push(item);
    }

    public Item removeLast() {
        if (forward.isEmpty() && backward.isEmpty()) return null;
        else if (backward.isEmpty()) balanceTo(forward, backward);
        N -= 1;
        return backward.pop();
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void balanceTo(Stack<Item> src, Stack<Item> dest) {
        int srcSize = src.size();
        popTo(src, temp, srcSize);
        popTo(temp, src, srcSize / 2);
        popTo(temp, dest, temp.size());
    }

    private void popTo(Stack<Item> src, Stack<Item> dest, int n) {
        for (int i = n; i > 0; --i)
            dest.push(src.pop());
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    @Override
    public String toString() {
        return forward.toString() + backward.toString();
    }

    private class DequeIterator implements Iterator<Item> {
        private final Iterator<Item> fi = forward.iterator();
        private final Iterator<Item> bi = backward.iterator();

        @Override
        public boolean hasNext() {
            return (fi.hasNext() || bi.hasNext());
        }

        @Override
        public Item next() {
            if (fi.hasNext()) return fi.next();
            else return bi.next();
        }
    }
}
