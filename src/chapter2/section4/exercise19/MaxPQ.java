package chapter2.section4.exercise19;

import java.util.Arrays;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ<Key extends Comparable<Key>> {
    @SuppressWarnings("FieldMayBeFinal")
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    // tag::snippet[]
    @SuppressWarnings("unchecked")
    public MaxPQ(Key[] a) {
        N = a.length;
        pq = (Key[]) new Comparable[N + 1];
        System.arraycopy(a, 0, pq, 1, N);
        for (int k = N / 2; k >= 1; k--)
            sink(k);
    }
    // end::snippet[]

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(pq);
        System.out.println(pq.isHeaped());
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

    private boolean isHeaped() {
        for (int i = N; i > 0; i--) {
            if (i / 2 > 0 && less(i / 2, i)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "pq=" + Arrays.toString(pq) +
                ", N=" + N +
                '}';
    }
}
