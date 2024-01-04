package ch1.sec5.ex12;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class QuickUnionCompressionUF {
    private final int[] id;
    private int count;

    public QuickUnionCompressionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionCompressionUF uf = new QuickUnionCompressionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println("id[]: " + Arrays.toString(uf.id));
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

        id[pRoot] = qRoot;
        compressComponent(p, qRoot);
        compressComponent(q, qRoot);

        count--;
    }

}
