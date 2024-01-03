package chapter1.section4.exercise10;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    public static int find(int key, int[] a) {
        int result = findR(key, a, 0, a.length - 1);
        return minimal(result, a);
    }

    public static int minimal(int result, int[] a) {
        if (result <= 0) {
            return result;
        } else if (a[result] == a[result - 1]) {
            return minimal(result - 1, a);
        } else {
            return result;
        }
    }

    public static int findR(int key, int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return findR(key, a, lo, mid - 1);
        else if (key > a[mid])
            return findR(key, a, mid + 1, hi);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 3, 3, 3, 4 };
        StdOut.println(find(3, a));
    }
}
