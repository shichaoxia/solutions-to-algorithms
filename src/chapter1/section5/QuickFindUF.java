package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private final int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Use one array access
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * Use between N + 3 and 2N + 1 array accesses
     */
    public void union(int p, int q) {
        int pID = find(p);  // One access
        int qID = find(q);  // One access

        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            // Iterating over all elements of the array uses N accesses.
            if (id[i] == pID) {
                // Write only one element using one read. (2+N+1)
                // Or write all remaining elements using N-1 accesses. (2+N+N-1)
                id[i] = qID;
            }
        count--;
    }
}
