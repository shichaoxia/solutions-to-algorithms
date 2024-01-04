package ch1.sec3;

public class FixedCapacityStackOfInts {
    private final int[] a;
    private int N;

    public FixedCapacityStackOfInts(int cap) {
        a = new int[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    
    public int size() {
        return N;
    }

    public void push(int item) {
        a[N++] = item;
    }

    @SuppressWarnings("UnusedReturnValue")
    public int pop() {
        return a[--N];
    }
}
