package chapter1.section1.exercise29;

public class Exercise29 {
    public static int bisearch(int key, int[] a) {
        return bisearchRecur(key, a, 0, a.length - 1);
    }

    public static int bisearchRecur(int key, int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return bisearchRecur(key, a, lo, mid - 1);
        else if (key > a[mid])
            return bisearchRecur(key, a, mid + 1, hi);
        else
            return mid;
    }

    public static int rank(int k, int[] a) {
        int idx = bisearch(k, a);
        if (idx == -1) {
            return 0;
        }
        if (idx == 0) {
            return 0;
        }
        while (a[idx - 1] == k) {
            idx -= 1;
        }
        return idx;
    }

    public static int count(int k, int[] a) {
        int idx = bisearch(k, a);
        if (idx == -1) {
            return 0;
        }
        return 1 + stepBackward(k, a, idx - 1) + stepForward(k, a, idx + 1);
    }

    public static int stepBackward(int k, int[] a, int idx) {
        if (idx < 0)
            return 0;
        if (a[idx] != k)
            return 0;
        return 1 + stepBackward(k, a, idx - 1);
    }

    public static int stepForward(int k, int[] a, int idx) {
        if (idx > a.length - 1)
            return 0;
        if (a[idx] != k)
            return 0;
        return 1 + stepForward(k, a, idx + 1);
    }
}
