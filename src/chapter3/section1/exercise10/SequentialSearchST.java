package chapter3.section1.exercise10;

import chapter3.section1.ST;

import java.util.ArrayList;
import java.util.List;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

    private Node first;
    private int N;

    private int comparesNum;

    public static void main(String[] args) {
        String[] keys = {"E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N"};
        ST<String, Integer> st = new SequentialSearchST<>();
        System.out.printf("%-6s | %-14s | %-69s%n", "Insert", "Total compares", "After insert");
        for (int i = 0; i < keys.length; i++)
            st.put(keys[i], i);
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next)
            if (equals(key, x.key)) {
                x.value = val;
                return;
            }
        first = new Node(key, val, first);
        N++;
        System.out.printf("%6s | %14s | %69s%n", "{" + key + ", " + val + "}", comparesNum, this);
    }

    private boolean equals(Key key1, Key key2) {
        comparesNum++;
        return key1.equals(key2);
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        for (Node x = first; x != null; x = x.next)
            if (equals(key, x.key))
                return x.value;
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (isEmpty())
            return;
        if (equals(key, first.key)) {
            Node oldFirst = first;
            first = first.next;
            oldFirst.next = null;
            return;
        }
        Node prev = first;
        Node curr = prev.next;
        while (curr != null) {
            if (equals(key, curr.key)) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            sb.append(x);
            if (x.next != null)
                sb.append(" ");
        }

        return sb.toString();
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}
