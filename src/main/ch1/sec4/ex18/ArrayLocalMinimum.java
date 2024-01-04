package ch1.sec4.ex18;

import edu.princeton.cs.algs4.StdOut;

public class ArrayLocalMinimum {

    public static int search(int[] a) {
        return searchRecur(a, 0, a.length - 1);
    }

    public static int searchRecur(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        StdOut.println(lo + ", " + mid + ", " + hi);
        if (mid == 0) {
            if (a[mid] < a[mid + 1])
                return mid;
            else
                return -1;
        } else if (1 <= mid && mid <= a.length - 2) {
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
                return mid;
            else if (a[mid - 1] < a[mid + 1])
                return searchRecur(a, lo, mid - 1);
            else
                return searchRecur(a, mid + 1, hi);
        } else { // mid == a.length - 1
            if (a[mid] < a[mid - 1])
                return mid;
            else
                return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 3, 7, 5, 6, 10, 9, 56, 32, 4, 1, 45 };
        int b = search(a);
        if (b >= 0)
            StdOut.println(a[b]);
    }

}
