package ch1.sec4.ex14;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class FourSumFast {
    public static int count(int[] a) {
        // mergesort is linearithmic
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    // binary search is logarithmic
                    if (BinarySearch.indexOf(a, -a[i] - a[j] - a[k]) > k)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        StdOut.println(count(a));
    }
}
