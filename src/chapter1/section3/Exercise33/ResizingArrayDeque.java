package chapter1.section3.exercise33;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayDeque<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    private int left;
    private int right;

    @SuppressWarnings("unchecked")
    public ResizingArrayDeque() {
        a = (Item[]) new Object[2];
        left = 0;
        right = 1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int k) {
        Item[] b = (Item[]) new Object[k];
        int bStart = (k - N) / 2;
        int bLeft = bStart - 1;
        for (int aStart = left + 1; aStart < right; aStart++, bStart++) {
            b[bStart] = a[aStart];
        }
        a = b;
        left = bLeft;
        right = bStart;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        if (left == -1)
            resize(2 * a.length);
        a[left] = item;
        left -= 1;
        N += 1;
    }

    public void pushRight(Item item) {
        if (right == a.length)
            resize(2 * a.length);
        a[right] = item;
        right += 1;
        N += 1;
    }

    public Item popLeft() {
        if (size() == 0)
            return null;
        Item item = a[left + 1];
        left += 1;
        N -= 1;
        if (N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public Item popRight() {
        if (size() == 0)
            return null;
        Item item = a[right - 1];
        right -= 1;
        N -= 1;
        if (N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        int current = left + 1;
        while (current != right) {
            s += " " + a[current];
            current += 1;
        }
        return s;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private int i = left + 1;

        public boolean hasNext() {
            return i < right;
        }

        public Item next() {
            Item item = a[i];
            i += 1;
            return item;
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> d = new ResizingArrayDeque<>();
        d.pushLeft("A");
        d.pushLeft("B");
        d.pushLeft("C");
        StdOut.println(d);
        d.pushRight("D");
        d.pushRight("E");
        d.pushRight("F");
        StdOut.println(d);
        d.popLeft();
        StdOut.println(d);
        d.popRight();
        StdOut.println(d);
    }
}
