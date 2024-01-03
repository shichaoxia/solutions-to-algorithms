package chapter2.section4.exercise5;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>(12);
        pq.insert("E");
        pq.insert("A");
        pq.insert("S");
        pq.insert("Y");
        pq.insert("Q");
        pq.insert("U");
        pq.insert("E");
        pq.insert("S");
        pq.insert("T");
        pq.insert("I");
        pq.insert("O");
        pq.insert("N");
        System.out.println("pq: " + Arrays.toString(pq.pq));
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
