package chapter1.section3.exercise36;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomQueue<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];
    private int first = 0;
    private int last = 0;

    
    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        return last - first;
    }

    @SuppressWarnings({"unchecked", "ManualArrayCopy", "DuplicatedCode"})
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = first; i < last; i++) {
            temp[i - first] = a[i];
        }
        a = temp;
        // Don't forget to reset cursors
        last -= first;
        first = 0;
    }

    public void enqueue(Item item) {
        if (last == a.length)
            resize(2 * a.length);
        a[last++] = item;
    }

    @SuppressWarnings("DuplicatedCode")
    public Item dequeue() {
        if (size() == 0)
            return null;
        if (0 < size() && size() < a.length / 4)
            resize(a.length / 2);

        switchFirstWithRandomItem();

        Item item = a[first];
        a[first++] = null;
        return item;
    }

    private void switchFirstWithRandomItem() {
        int randomIndex = StdRandom.uniform(first, last);
        Item temp = a[randomIndex];
        a[randomIndex] = a[first];
        a[first] = temp;
    }

    
    public Item sample() {
        Item item = dequeue();
        enqueue(item);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private final Item[] randomA = Arrays.copyOfRange(a, first, last);
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
        RandomQueue<Integer> q = new RandomQueue<>();
        for (int i = 1; i <= 5; i++) {
            q.enqueue(i);
        }
        for (Integer i : q) {
            StdOut.println(i);
        }
    }

}
