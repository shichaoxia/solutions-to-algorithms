package ch1.sec1.ex39;

import java.util.Arrays;

import ch1.sec1.ex38.Ex38;
import edu.princeton.cs.algs4.StdRandom;

public class Ex39 {

    public static int[][] experiment(int T) {
        int[] Ns = { 1000, 10000, 100000, 1000000 };
        int[][] quantities = new int[T][Ns.length];
        for (int j = 0; j < T; j++) {
            for (int i = 0; i < Ns.length; i++) {
                int[] a = new int[Ns[i]];
                for (int k = 0; k < a.length; k++)
                    a[k] = StdRandom.uniform(0, 1000000);
                int[] b = new int[Ns[i]];
                for (int k = 0; k < b.length; k++) {
                    b[k] = StdRandom.uniform(0, 1000000);
                }
                int r = 0;
                for (int item : a) {
                    if (Ex38.biSearch(item, b) >= 0)
                        r += 1;
                }
                quantities[j][i] = r;
            }
        }
        return quantities;
    }

    public static int[] probabilityExperiment(int[][] e) {
        int[] avg = new int[e[0].length];
        for (int i = 0; i < e[0].length; i++) {
            for (int[] ints : e) {
                avg[i] += ints[i];
            }
        }
        Arrays.stream(avg).map(i -> i / e.length);
        return avg;
    }
}
