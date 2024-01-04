package ch1.sec4;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class TwoSumFast {
    
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (BinarySearch.indexOf(a, -a[i]) > i)
                cnt++;
        return cnt;
    }
}
