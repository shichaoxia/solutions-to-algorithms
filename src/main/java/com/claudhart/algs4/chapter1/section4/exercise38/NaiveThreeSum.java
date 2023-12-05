package com.claudhart.algs4.chapter1.section4.exercise38;

public class NaiveThreeSum {
    @SuppressWarnings("UnusedReturnValue")
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (i < j && j < k)
                        if (a[i] + a[j] + a[k] == 0)
                            cnt++;
        return cnt;
    }
}
