package com.claudhart.algs4.chapter1.section1.exercise30;

public class Exercise30 {
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    // Calculate only non-zero positive integers
    public static Boolean coprime(int p, int q) {
        if (p < 1 || q < 1) {
            return null;
        }
        return gcd(p, q) == 1;
    }

    public static Boolean[][] matrix(int N) {
        Boolean[][] a = new Boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = coprime(i, j);
            }
        }
        return a;
    }
}
