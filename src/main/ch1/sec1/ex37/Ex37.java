package ch1.sec1.ex37;

import edu.princeton.cs.algs4.StdRandom;

public class Ex37 {

    public static void awfulShuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
