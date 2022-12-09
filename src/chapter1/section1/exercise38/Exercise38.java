package chapter1.section1.exercise38;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise38 {
    public static int bruteForceSearch(int key, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key)
                return i;
        return -1;
    }

    public static int biSearch(int key, int[] a) {
        return biSearchRecur(key, a, 0, a.length - 1);
    }

    public static int biSearchRecur(int key, int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return biSearchRecur(key, a, lo, mid - 1);
        else if (key > a[mid])
            return biSearchRecur(key, a, mid + 1, hi);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        int[] keys = StdIn.readAllInts();

        long startTime = System.currentTimeMillis();
        for (int key : keys) {
            if (biSearch(key, whitelist) < 0)
                StdOut.println(key);
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        StdOut.printf("biSearch elapsed millis: %d%n", elapsedTime);

        startTime = System.currentTimeMillis();
        for (int key : keys) {
            if (bruteForceSearch(key, whitelist) < 0)
                StdOut.println(key);
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        StdOut.printf("bruteForceSearch elapsed millis: %d%n", elapsedTime);
    }
}
