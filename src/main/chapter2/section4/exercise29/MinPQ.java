package chapter2.section4.exercise29;

@SuppressWarnings("DuplicatedCode")
public class MinPQ {
    private final Item[] pq;
    private int N = 0;

    public MinPQ(int maxN) {
        pq = new Item[maxN + 1];
    }

    
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Item v) {
        pq[++N] = v;
        v.minIndex = N;
        swim(N);
    }

    public Item delMin() {
        Item max = pq[1];
        del(1);
        return max;
    }

    public void del(int k) {
        exch(k, N--);
        pq[N + 1] = null;
        sink(k);
    }

    public Item findMin() {
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
        Item swap = pq[i];
        pq[i] = pq[j];
        pq[i].minIndex = i;
        pq[j] = swap;
        pq[j].minIndex = j;
    }
}
