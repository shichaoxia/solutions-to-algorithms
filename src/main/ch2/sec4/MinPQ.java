package ch2.sec4;

@SuppressWarnings("DuplicatedCode")
public class MinPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
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

    public Key delMin() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public Key peek() {
        return pq[1];
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
