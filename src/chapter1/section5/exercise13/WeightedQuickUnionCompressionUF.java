package chapter1.section5.exercise13;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class WeightedQuickUnionCompressionUF {

    private final int[] id;
    private final int[] sz;
    private int count;

    public WeightedQuickUnionCompressionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionCompressionUF uf = new WeightedQuickUnionCompressionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println("id[]: " + Arrays.toString(uf.id));
        StdOut.println("sz[]: " + Arrays.toString(uf.sz));
        StdOut.println("site 0's depth: " + uf.depth(0));
    }

    public int count() {
        return count;
    }

    public int depth(int p) {
        return depth(p, 0);
    }

    public int depth(int p, int cnt) {
        if (p == id[p]) return cnt;
        else return depth(id[p], cnt + 1);
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        if (p == id[p]) return p;
        else return find(id[p]);
    }

    public void compressComponent(int p, int root) {
        if (p != root) {
            int next = id[p];
            id[p] = root;
            compressComponent(next, root);
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        int smaller = sz[pRoot] <= sz[qRoot] ? pRoot : qRoot;
        int larger = smaller == pRoot ? qRoot : pRoot;

        id[smaller] = larger;
        sz[larger] += sz[smaller];

        compressComponent(p, larger);
        compressComponent(q, larger);

        count--;
    }

}
