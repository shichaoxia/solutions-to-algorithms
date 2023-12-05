package com.claudhart.algs4.chapter1.section4.exercise20;

import com.claudhart.algs4.chapter1.section1.BinarySearch;

public class BitonicSearch {

    public final static int NOT_FOUND = -1;

    /**
     * @return the index of the peek element
     */
    public static int searchPeek(int[] a) {
        return searchPeek(a, 0, a.length - 1);
    }

    public static int searchPeek(int[] a, int lo, int hi) {
        if (lo == hi) return lo;

        if (lo + 1 == hi) {
            if (a[lo] < a[hi]) return hi;
            return lo;
        }

        int mid = (lo + hi) / 2;

        if (a[mid - 1] < a[mid]) {                 // inside increasing sequence
            if (a[mid] > a[mid + 1]) return mid;   // peek
            return searchPeek(a, mid + 1, hi);     // middle element
        }

        return searchPeek(a, lo, mid - 1);         // inside decreasing sequence
    }

    public static int searchMaximum(int[] a, int key) {
        int peek = searchPeek(a);
        if (a[peek] == key) return peek;

        int searchLeft = BinarySearch.rank(key, a, 0, peek - 1);
        if (searchLeft != NOT_FOUND) return searchLeft;

        int searchRight = inverseRank(key, a, peek + 1, a.length - 1);
        if (searchRight != NOT_FOUND) return searchRight;

        return NOT_FOUND;
    }

    /**
     * @return the element found in the descending sequence or -1 if not found
     */
    public static int inverseRank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return NOT_FOUND;

        int mid = (lo + hi) / 2;

        if (key > a[mid]) return inverseRank(key, a, lo, mid - 1);
        else if (key < a[mid]) return inverseRank(key, a, mid + 1, hi);
        else return mid;
    }
}
