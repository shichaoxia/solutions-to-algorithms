package chapter1.section3.Exercise34;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomBag<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private Item[] randomA = Arrays.copyOf(a, N);
        private int current = 0;

        public RandomIterator() {
            StdRandom.shuffle(randomA);
        }

        @Override
        public boolean hasNext() {
            return current < randomA.length;
        }

        @Override
        public Item next() {
            return randomA[current++];
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> b = new RandomBag<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        for (Integer i : b) {
            StdOut.println(i);
        }
    }
}
