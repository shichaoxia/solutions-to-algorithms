package ch1.sec3.ex38;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueue1<Item> {
    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    
    public boolean isEmpty() {
        return N == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public void insert(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    @SuppressWarnings("UnusedReturnValue")
    public Item delete(int k) {
        Item item = a[k];

        // Move elements form k+1 to N-1 forward by one
        int count = N - 1 - k;
        while (count > 0) {
            a[k] = a[k + 1];
            count -= 1;
            k += 1;
        }
        a[N - 1] = null;

        N -= 1;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public Item[] getA() {
        return a;
    }

    public static void main(String[] args) {
        GeneralizedQueue1<String> q = new GeneralizedQueue1<>();
        q.insert("A");
        q.insert("B");
        q.insert("C");
        q.insert("D");
        q.insert("E");
        StdOut.println(Arrays.toString(q.getA()));
        q.delete(0);
        q.delete(1);
        q.delete(2);
        StdOut.println(Arrays.toString(q.getA()));
    }

}
