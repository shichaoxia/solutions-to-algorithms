package ch1.sec3;



import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    
    public boolean isEmpty() {
        return N == 0;
    }

    
    public int size() {
        return N;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N] = item;
        N += 1;
    }

    public Item pop() {
        if (N == 0) return null;
        Item item = a[N - 1];
        a[N - 1] = null;
        N -= 1;
        if (N == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }
    }
}
