package chapter3.section1.exercise2;

import chapter1.section3.Queue;
import chapter3.section1.ST;


public class ArrayST<Key, Value> implements ST<Key, Value> {

    private Key[] keys;
    private Value[] values;

    private int n;

    @SuppressWarnings("unchecked")
    public ArrayST() {
        keys = (Key[]) new Object[1];
        values = (Value[]) new Object[1];
    }

    public static void main(String[] args) {
        ST<String, Integer> st = new ArrayST<>();
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        st.put("d", 4);
        st.put("e", 5);
        for (String s : st.keys()) System.out.println(s + " " + st.get(s));

        st.delete("c");
        System.out.println("After delete c:");
        for (String s : st.keys()) System.out.println(s + " " + st.get(s));

        st.delete("a");
        System.out.println("After delete a:");
        for (String s : st.keys()) System.out.println(s + " " + st.get(s));
    }

    @Override
    public void put(Key key, Value val) {
        if (val == null)
            throw new IllegalArgumentException("val cannot be null");

        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }

        if (n == keys.length) {
            resize(2 * keys.length);
        }

        keys[n] = key;
        values[n] = val;
        n++;
    }

    @Override
    public Value get(Key key) {
        int i = find(key);
        if (i == -1) return null;
        return values[i];
    }

    
    @Override
    public void delete(Key key) {
        if (isEmpty()) return;
        int i = find(key);
        if (i == -1) return;
        shiftLeft(i);
        n--;
        if (n > 0 && n == keys.length / 4)
            resize(keys.length / 2);
    }

    private int find(Key key) {
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) return i;
        }
        return -1;
    }

    private void shiftLeft(int i) {
        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        keys[n - 1] = null;
        values[n - 1] = null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        for (int i = 0; i < n; i++)
            if (values[i] != null) q.enqueue(keys[i]);
        return q;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Object[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];

        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }

        keys = tempKeys;
        values = tempValues;
    }
}
