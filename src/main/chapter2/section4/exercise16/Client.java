package chapter2.section4.exercise16;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        int N = 32;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) a[i] = i;
        ArrayAndCompares most = null;
        ArrayAndCompares least = null;
        int trails = 10_000_000;
        for (int i = 0; i < trails; i++) {
            StdRandom.shuffle(a);
            Integer[] copy = a.clone();
            int compares = Heapsort.sort(a);
            if (most == null || compares > most.compares) most = new ArrayAndCompares(copy, compares);
            if (least == null || compares < least.compares) least = new ArrayAndCompares(copy, compares);
        }
        System.out.println("Most compares: " + most.compares);
        System.out.println(Arrays.toString(most.array));
        System.out.println("Least compares: " + least.compares);
        System.out.println(Arrays.toString(least.array));
    }

    private record ArrayAndCompares(Integer[] array, int compares) implements Comparable<ArrayAndCompares> {
        public int compareTo(ArrayAndCompares that) {
            return this.compares - that.compares;
        }
    }
}
