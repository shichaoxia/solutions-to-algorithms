package chapter2.section4.exercise15;

@SuppressWarnings("DuplicatedCode")
public class MinPQ<Key extends Comparable<Key>> {
    @SuppressWarnings("FieldMayBeFinal")
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>(10);
        for (int i = 0; i < 10; i++) {
            pq.insert(i);
        }
        System.out.println(pq.check());
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

    @SuppressWarnings("unused")
    public Key delMin() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
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

    // tag::snippet[]
    private boolean check() {
        for (int i = N; i > 0; i--)
            if (i / 2 > 0 && greater(i / 2, i)) return false;
        return true;
    }
    // end::snippet[]
}
