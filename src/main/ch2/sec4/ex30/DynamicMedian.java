package ch2.sec4.ex30;


import ch2.sec4.MaxPQ;
import ch2.sec4.MinPQ;

public class DynamicMedian<Key extends Comparable<Key>> {

    private final MaxPQ<Key> maxPQ;
    private final MinPQ<Key> minPQ;

    public DynamicMedian(int maxN) {
        maxPQ = new MaxPQ<>(maxN / 2 + 1);
        minPQ = new MinPQ<>(maxN / 2 + 1);
    }

    public void insert(Key item) {
        if (maxPQ.isEmpty())
            maxPQ.insert(item);
        else if (item.compareTo(maxPQ.peek()) < 0)
            maxPQ.insert(item);
        else
            minPQ.insert(item);
        balanceHeaps();
    }

    public Key findMedian() {
        if (maxPQ.size() < minPQ.size())
            return minPQ.peek();
        return maxPQ.peek();
    }

    public Key deleteMedian() {
        if (maxPQ.size() < minPQ.size())
            return minPQ.delMin();
        return maxPQ.delMax();
    }

    private void balanceHeaps() {
        while (maxPQ.size() - minPQ.size() > 1)
            minPQ.insert(maxPQ.delMax());

        while (minPQ.size() - maxPQ.size() > 1)
            maxPQ.insert(minPQ.delMin());
    }
}
