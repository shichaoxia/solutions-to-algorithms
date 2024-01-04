package ch1.sec4.ex19;

import ch1.sec4.ex18.ArrayLocalMinimum;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("ClassEscapesDefinedScope")
public class MatrixLocalMinimum {

    public static Pair search(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int j = ArrayLocalMinimum.search(a[i]);
            if (j >= 0 && eligible(a, i, j))
                return new Pair(i, j);
        }
        return null;
    }

    private static boolean eligible(int[][] a, int i, int j) {
        if (j == 0)
            return a[i][j] < a[i][j + 1];
        else if (j == a.length - 1)
            return a[i][j] < a[i][j - 1];
        else
            return a[i][j] < a[i][j + 1] && a[i][j] < a[i][j - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                { 4, 4, 6, 8, 9, 4, 3, 6 },
                { 2, 1, 6, 8, 9, 4, 3, 6 },
                { 1, 3, 6, 8, 9, 4, 3, 6 },
                { 1, 3, 6, 8, 9, 4, 3, 6 },
                { 7, 2, 7, 9, 5, 4, 3, 6 },
                { 4, 7, 8, 5, 9, 4, 3, 6 },
                { 9, 4, 7, 8, 2, 4, 3, 6 },
                { 0, 2, 5, 3, 7, 4, 3, 6 }
        };
        StdOut.println(search(a));
    }

    private record Pair(int i, int j) {
    }
}
