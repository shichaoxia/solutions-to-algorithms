package chapter1.section4.exercise11;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i];
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public int howMany(int key) {
        int found = rank(key);
        if (found < 0)
            return 0;
        int forwardCnt = 0;
        for (int i = found; i > 0 && a[i] == a[i - 1]; --i) {
            forwardCnt += 1;
        }
        int backwardCnt = 0;
        for (int i = found; i < a.length - 1 && a[i] == a[i + 1]; ++i) {
            backwardCnt += 1;
        }
        return forwardCnt + 1 + backwardCnt;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 2, 2, 2, 2, 3 };
        StaticSETofInts s = new StaticSETofInts(a);
        StdOut.println(s.rank(2));
        StdOut.println(s.howMany(2));
    }
}
