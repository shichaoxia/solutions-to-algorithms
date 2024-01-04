package ch2.sec3.ex26;

import edu.princeton.cs.algs4.StdOut;

import java.util.Map;

import static ch2.sec3.ex26.Quick.sort;

@SuppressWarnings({"rawtypes"})
public class SortCompare {

    public static void main(String[] args) {
        compareSubarraySizes();
    }

    private static void compareSubarraySizes() {
        StdOut.printf("%nCompare the length distribution of subarrays at different M:%n");
        StdOut.printf("%10s %10s%n", "M", "subarrays");
        Integer[] cutoffs = {10, 20, 50};
        int N = (int) 10e5;
        Comparable[] a = generateArray(N);
        Map<Integer, Integer> countMap;
        for (int M : cutoffs) {
            sort(a, M);
            countMap = Quick.countMap;
            StdOut.printf("%10s %s%n", M, countMap.toString());
        }
    }

    private static Comparable[] generateArray(int length) {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
