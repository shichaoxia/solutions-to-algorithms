package com.claudhart.algs4.chapter1.section4.exercise14;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class FourSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    for (int p = k + 1; p < N; p++)
                        if (a[i] + a[j] + a[k] + a[p] == 0)
                            cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        StdOut.println(count(a));
    }
}
