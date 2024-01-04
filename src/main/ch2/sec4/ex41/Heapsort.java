package ch2.sec4.ex41;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class Heapsort {

    private static int comparesNum;

    public static int sort(Comparable[] a) {
        comparesNum = 0;
        int N = a.length - 1;
        for (int k = (N - 1) / 2; k >= 0; k--)
            sink(a, k, N);
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
        return comparesNum;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k + 1 <= N) {
            int j = 2 * k + 1;
            if (j + 1 <= N && less(a, j, j + 1)) j += 1;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable[] a, int i, int j) {
        comparesNum++;
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int standard, threeAry, fourAry;
        System.out.printf("%20s %10s %10s %10s\n", "N\\compares/version", "standard", "3-ary", "4-ary");
        for (int N = 1_000; N <= 1_000_000; N *= 10) {
            standard = sort(generateRandomArray(N));
            threeAry = HeapsortThreeAry.sort(generateRandomArray(N));
            fourAry = HeapsortFourAry.sort(generateRandomArray(N));
            System.out.printf("%20d %10d %10d %10d\n", N, standard, threeAry, fourAry);
        }
    }

    private static Double[] generateRandomArray(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }

}
