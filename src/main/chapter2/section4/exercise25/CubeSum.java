package chapter2.section4.exercise25;

import chapter2.section4.MinPQ;

public class CubeSum {

    // tag::snippet[]
    public static void main(String[] args) {
        int N = 1000;
        MinPQ<Item> pq = new MinPQ<>(N + 1);
        for (int i = 0; i <= N; i++) {
            pq.insert(new Item(i, i));
        }
        int cnt = 0;
        Item last = pq.delMin();
        System.out.printf("%4s %10s %4s %4s %4s %4s %n", "No.", "sum", "a", "b", "c", "d");
        while (!pq.isEmpty()) {
            Item item = pq.delMin();
            if (item.sameSumDifferentFactors(last)) {
                cnt++;
                System.out.printf("%4d %10d %4d %4d %4d %4d %n", cnt, last.sum, last.i, last.j, item.i, item.j);
            }
            last = item;
            if (item.j < N) {
                pq.insert(new Item(item.i, item.j + 1));
            }
        }
    }
    // end::snippet[]

    private static class Item implements Comparable<Item> {
        private final int i;
        private final int j;
        private final int sum;

        public Item(int i, int j) {
            this.i = i;
            this.j = j;
            this.sum = i * i * i + j * j * j;
        }

        public boolean sameSumDifferentFactors(Item other) {
            return this.sum == other.sum && this.i != other.i && this.j != other.j && this.i != other.j && this.j != other.i;
        }

        @Override
        public int compareTo(Item that) {
            return Integer.compare(this.sum, that.sum);
        }

        @Override
        public String toString() {
            return String.format("%d, %d, %d", sum, i, j);
        }
    }
}
