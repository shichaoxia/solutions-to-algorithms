package ch1.sec2.ex9;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex9 {
    public static int biSearch(int key, int[] a, Counter c) {
        return biSearchRecur(key, a, 0, a.length - 1, c);
    }

    public static int biSearchRecur(int key, int[] a, int lo, int hi, Counter c) {
        c.increment();
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return biSearchRecur(key, a, lo, mid - 1, c);
        else if (key > a[mid])
            return biSearchRecur(key, a, mid + 1, hi, c);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        int[] keys = StdIn.readAllInts();
        Counter c = new Counter("ex9");
        StdOut.println("Not in whitelist: ");
        for (int key : keys) {
            if (biSearch(key, whitelist, c) < 0)
                StdOut.println(key);
        }
        StdOut.printf("Search %d candidates in the whitelist of %d items%n", keys.length, whitelist.length);
        StdOut.printf("Execute binary search %d times%n", c.tally());
    }
}
