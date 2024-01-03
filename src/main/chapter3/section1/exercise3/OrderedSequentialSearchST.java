package chapter3.section1.exercise3;

import chapter3.section1.OrderedST;

import java.util.ArrayList;
import java.util.List;


public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Node first;
    private int size;

    
    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (val == null) {
            delete(key);
            return;
        }
        if (isEmpty()) {
            first = new Node(key, val, null);
            size++;
            return;
        }
        if (key.compareTo(first.key) < 0) {
            first = new Node(key, val, first);
            size++;
            return;
        }
        Node prev = first;
        Node curr = first.next;
        while (curr != null && key.compareTo(curr.key) > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null && key.compareTo(curr.key) == 0) {
            curr.val = val;
            return;
        }
        prev.next = new Node(key, val, curr);
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        Node curr = first;
        while (curr != null) {
            if (key.compareTo(curr.key) == 0) return curr.val;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (isEmpty()) return;
        if (key.compareTo(first.key) == 0) {
            first = first.next;
            size--;
            return;
        }
        Node prev = first;
        Node curr = first.next;
        while (curr != null && key.compareTo(curr.key) > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null && key.compareTo(curr.key) == 0) {
            prev.next = curr.next;
            size--;
        }
    }

    
    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    
    @Override
    public int size() {
        return size;
    }

    
    @Override
    public Key min() {
        if (isEmpty()) return null;
        return first.key;
    }

    
    @Override
    public Key max() {
        if (isEmpty()) return null;
        Node curr = first;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.key;
    }

    
    @Override
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        if (isEmpty()) return null;
        if (key.compareTo(first.key) < 0) return null;
        Node curr = first;
        while (curr.next != null && key.compareTo(curr.next.key) >= 0) {
            curr = curr.next;
        }
        return curr.key;
    }

    
    @Override
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        Node curr = first;
        while (curr != null && key.compareTo(curr.key) > 0) {
            curr = curr.next;
        }
        if (curr == null) return null;
        return curr.key;
    }

    
    @Override
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int rank = 0;
        Node curr = first;
        while (curr != null && key.compareTo(curr.key) > 0) {
            rank++;
            curr = curr.next;
        }
        if (curr != null && key.compareTo(curr.key) == 0) return rank;
        return -1;
    }

    
    @Override
    public Key select(int k) {
        if (k < 0 || k >= size) throw new IllegalArgumentException("Invalid index");
        Node curr = first;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }
        return curr.key;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) return;
        first = first.next;
        size--;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) return;
        if (size == 1) {
            first = null;
            size--;
            return;
        }
        Node prev = first;
        Node curr = first.next;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        size--;
    }

    
    @Override
    public int size(Key lo, Key hi) {
        if (lo == null || hi == null) throw new IllegalArgumentException("Keys cannot be null");
        if (lo.compareTo(hi) > 0) return 0;
        int count = 0;
        Node curr = first;
        while (curr != null && curr.key.compareTo(lo) < 0) {
            curr = curr.next;
        }
        while (curr != null && curr.key.compareTo(hi) <= 0) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    
    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) throw new IllegalArgumentException("Keys cannot be null");
        if (lo.compareTo(hi) > 0) return null;
        List<Key> list = new ArrayList<>();
        Node curr = first;
        while (curr != null && curr.key.compareTo(lo) < 0) {
            curr = curr.next;
        }
        while (curr != null && curr.key.compareTo(hi) <= 0) {
            list.add(curr.key);
            curr = curr.next;
        }
        return list;
    }

    
    @Override
    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<>();
        Node curr = first;
        while (curr != null) {
            list.add(curr.key);
            curr = curr.next;
        }
        return list;
    }

    private class Node {
        final Key key;
        Value val;
        Node next;

        
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
