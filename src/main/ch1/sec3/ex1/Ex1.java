package ch1.sec3.ex1;


public class Ex1 {
    public static class FixedCapacityStackOfStrings {

        private final String[] a; // stack entries
        private int N; // size

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }


        public boolean isEmpty() {
            return N == 0;
        }


        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }


        public String pop() {
            return a[--N];
        }

        public boolean isFull() {
            return a.length == N;
        }
    }
}
