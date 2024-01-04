package ch2.sec4.ex3;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public OrderedArrayMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<>(10);
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
        for (int i = N - 1; i > 0; i--) {
            if (less(i, i - 1)) exch(i, i - 1);
        }
    }

    public Key delMax() {
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
