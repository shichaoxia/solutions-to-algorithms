package ch1.sec5.ex26;

import ch1.sec5.QuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class AmortizedPlotForErdosRenyi {

    public static void main(String[] args) {


        int N = Integer.parseInt(args[0]);

        ch1.sec5.QuickUnionUF uf = new QuickUnionUF(N);
        for (int i = 1; true; ++i) {
            int m = StdRandom.uniform(N);
            int n = StdRandom.uniform(N);
            if (uf.connected(m, n)) continue;
            uf.union(m, n);
            if (uf.count() == 1) {
                StdOut.println(i + " pairs");
                break;
            }
        }
    }
}
