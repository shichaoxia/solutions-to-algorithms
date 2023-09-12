package chapter1.section3;

public class FixedCapacityStack<Item> {
    private final Item[] a; // stack entries
    private int N; // size public

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}
