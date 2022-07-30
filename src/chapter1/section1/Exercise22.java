package chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise22 {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 1);
    }

    public static int rank(int key, int[] a, int lo, int hi, int level) {
        printIndent(level);
        System.out.printf("lo: %d, hi: %d%n", lo, hi);

        if (lo > hi)
            return -1;

        int mid = lo + (hi - lo) / 2;

        if (key < a[mid])
            return rank(key, a, lo, mid - 1, ++level);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, ++level);
        else
            return mid;
    }

    static void printIndent(int level) {
        while (level > 1) {
            System.out.print("    ");
            level -= 1;
        }
    }

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        StdOut.println(Arrays.toString(whitelist));
        while (!StdIn.isEmpty()) {
            // 读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}
