package com.claudhart.algs4.chapter3.section1.exercise25;

import com.claudhart.algs4.chapter3.section1.ST;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class CachedSequentialSearchST<Key, Value> implements ST<Key, Value> {
    private Node first;
    private int N;
    // tag::snippet[]
    private Node cachedNode;

    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (val == null) {
            delete(key);
            if (cachedNode != null && key.equals(cachedNode.key))
                cachedNode = null;
            return;
        }
        if (cachedNode != null && key.equals(cachedNode.key)) {
            cachedNode.value = val;
            return;
        }
        Node i = find(key);
        if (i != null) {
            i.value = val;
            cachedNode = i;
            return;
        }
        first = new Node(key, val, first);
        cachedNode = first;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (cachedNode != null && key.equals(cachedNode.key))
            return cachedNode.value;
        Node i = find(key);
        if (i != null) {
            cachedNode = i;
            return i.value;
        }
        return null;
    }
    // end::snippet[]

    @Override
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<>();
        for (Node x = first; x != null; x = x.next)
            list.add(x.key);
        return list;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (isEmpty())
            return;
        if (key.equals(first.key)) {
            Node oldFirst = first;
            first = first.next;
            oldFirst.next = null;
            return;
        }
        Node prev = first;
        Node curr = prev.next;
        while (curr != null) {
            if (key.equals(curr.key)) {
                prev.next = curr.next;
                curr.next = null;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        N--;
    }

    private Node find(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x;
        return null;
    }

    private class Node {
        final Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
