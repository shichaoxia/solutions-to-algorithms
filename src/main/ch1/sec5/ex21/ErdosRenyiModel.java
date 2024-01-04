package ch1.sec5.ex21;

import ch1.sec5.QuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyiModel {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int trialNum = Integer.parseInt(args[1]);
        int cumulativePairs = 0;
        for (int j = trialNum; j > 0; --j) {
            QuickUnionUF uf = new QuickUnionUF(N);
            for (int i = 1; true; ++i) {
                int m = StdRandom.uniform(N);
                int n = StdRandom.uniform(N);
                if (uf.connected(m, n)) continue;
                uf.union(m, n);
                if (uf.count() == 1) {
                    cumulativePairs += i;
                    StdOut.println(i + " pairs");
                    break;
                }
            }
        }
        StdOut.printf("N: %d, Average pairs: %d, hypothesis: %.0f%n", N, cumulativePairs / trialNum, N * Math.log(N) / 2.0);
    }

}
