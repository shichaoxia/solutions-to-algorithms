package chapter2.section5.exercise19;

import java.util.Arrays;

public class Inversions {

    /**
     * Returns the number of inversions in the integer array.
     * The argument array is not modified.
     *
     * @param a the array
     * @return the number of inversions in the array. An inversion is a pair of
     * indices {@code i} and {@code j} such that {@code i < j}
     * and {@code a[i] > a[j]}.
     */
    
    public static long count(int[] a) {
        int[] b = Arrays.copyOf(a, a.length);
        int[] aux = new int[a.length];
        return count(b, aux, 0, a.length - 1);
    }

    // return the number of inversions in the subarray b[lo...hi]
    // side effect b[lo...hi] is rearranged in ascending order
    private static long count(int[] b, int[] aux, int lo, int hi) {
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        return count(b, aux, lo, mid) + count(b, aux, mid + 1, hi) + merge(b, aux, lo, mid, hi);
    }

    // inversions can be obtained from the process of merge sort,
    // it is a bit difficult to understand
    private static long merge(int[] b, int[] aux, int lo, int mid, int hi) {
        long inversions = 0;

        // copy to aux[]
        System.arraycopy(b, lo, aux, lo, hi - lo + 1);

        // merge back to b[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) b[k] = aux[j++];      // Deplete the left and take from the right
            else if (j > hi) b[k] = aux[i++];  // Deplete the right and take from the left
            else if (aux[j] < aux[i]) {        // If the right is less than the left, take from the right
                b[k] = aux[j++];
                inversions += (mid - i + 1);
            } else b[k] = aux[i++];            // Take from the left
        }
        return inversions;
    }
}
