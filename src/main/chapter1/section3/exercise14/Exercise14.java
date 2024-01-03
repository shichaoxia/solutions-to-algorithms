package chapter1.section3.exercise14;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;


public class Exercise14 {
    public static class ResizingArrayQueueOfStrings implements Iterable<String> {
        private String[] a = new String[1];
        private int first = 0;
        private int last = 0;

        
        public boolean isEmpty() {
            return first == last;
        }

        public int size() {
            return last - first;
        }

        @SuppressWarnings("ManualArrayCopy")
        private void resize(int max) {
            String[] temp = new String[max];
            for (int i = first; i < last; i++) {
                temp[i - first] = a[i];
            }
            a = temp;
            // Don't forget to reset cursors
            last -= first;
            first = 0;
        }

        public void enqueue(String item) {
            if (last == a.length)
                resize(2 * a.length);
            a[last++] = item;
        }

        @SuppressWarnings("UnusedReturnValue")
        public String dequeue() {
            if (size() == 0)
                return null;
            if (0 < size() && size() < a.length / 4)
                resize(a.length / 2);
            String item = a[first];
            a[first++] = null;
            return item;
        }

        @Override
        public String toString() {
            int current = first;
            StringBuilder s = new StringBuilder();
            while (current != last) {
                s.insert(0, a[current] + " ");
                current += 1;
            }
            s = new StringBuilder(s.toString().stripTrailing());
            return "Queue >[" + s + "]>@" + System.identityHashCode(this);
        }

        public Iterator<String> iterator() {
            return new ArrayQueueIterator();
        }

        private class ArrayQueueIterator implements Iterator<String> {
            private int i = first;

            public boolean hasNext() {
                return i < last;
            }

            public String next() {
                return a[i++];
            }

            public void remove() {
            }
        }

        public String innerArrayString() {
            return Arrays.toString(a);
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        q.enqueue("A");
        StdOut.println("Enqueue A, first :" + q.first + ", last: " + q.last + ", inner array: " + q.innerArrayString());
        q.enqueue("B");
        StdOut.println("Enqueue B, first :" + q.first + ", last: " + q.last + ", inner array: " + q.innerArrayString());
        q.dequeue();
        StdOut.println("Dequeue  , first :" + q.first + ", last: " + q.last + ", inner array: " + q.innerArrayString());
        q.enqueue("C");
        StdOut.println("Enqueue C, first :" + q.first + ", last: " + q.last + ", inner array: " + q.innerArrayString());
        StdOut.println("q: "+q);
        StdOut.printf("Iter q: ");
        for (String item : q) {
            StdOut.print(item);
        }
        StdOut.println("");
    }
}
