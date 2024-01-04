package ch1.sec5.ex17;

import ch1.sec5.QuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        QuickUnionUF uf = new QuickUnionUF(N);
        for (int i = Integer.parseInt(args[1]); i > 0; --i) {
            int m = StdRandom.uniform(N);
            int n = StdRandom.uniform(N);
            if (uf.connected(m, n)) continue;
            uf.union(m, n);
            StdOut.println(m + " " + n);
        }
        StdOut.println(uf.count() + " components");
    }

}
