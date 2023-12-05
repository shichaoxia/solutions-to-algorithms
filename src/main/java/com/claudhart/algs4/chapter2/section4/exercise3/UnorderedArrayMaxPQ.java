package com.claudhart.algs4.chapter2.section4.exercise3;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    @SuppressWarnings("FieldMayBeFinal")
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public UnorderedArrayMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<>(10);
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        pq.insert(5);
        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // tag::snippet[]
    public void insert(Key v) {
        pq[N++] = v;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i)) max = i;
        }
        exch(max, N - 1);
        Key maxKey = pq[--N];
        pq[N] = null;
        return maxKey;
    }
    // end::snippet[]

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
