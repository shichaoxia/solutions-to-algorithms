package chapter1.section3.Exercise35;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> {

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

    @SuppressWarnings("unchecked")
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

    public static void main(String[] args) {
        RandomQueue<Integer> q = new RandomQueue<>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                q.enqueue(j);
            }
        }
        Queue<Integer> a = new Queue<>();
        Queue<Integer> b = new Queue<>();
        Queue<Integer> c = new Queue<>();
        Queue<Integer> d = new Queue<>();

        for (int j = 1; j <= 13; j++) {
            a.enqueue(q.dequeue());
        }
        for (int j = 1; j <= 13; j++) {
            b.enqueue(q.dequeue());
        }
        for (int j = 1; j <= 13; j++) {
            c.enqueue(q.dequeue());
        }
        for (int j = 1; j <= 13; j++) {
            d.enqueue(q.dequeue());
        }

        StdOut.println("Player A's cards: " + a);
        StdOut.println("Player B's cards: " + b);
        StdOut.println("Player C's cards: " + c);
        StdOut.println("Player D's cards: " + d);
    }
}
