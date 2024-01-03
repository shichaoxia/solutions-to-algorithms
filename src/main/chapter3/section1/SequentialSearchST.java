package chapter3.section1;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

    private Node first;
    private int N;

    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.value = val;
                return;
            }
        first = new Node(key, val, first);
        N++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.value;
        return null;
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
