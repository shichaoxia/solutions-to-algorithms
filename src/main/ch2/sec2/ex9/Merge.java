package ch2.sec2.ex9;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
public class Merge {

    public static void sort(Comparable[] a, Comparable[] aux) {
        sort(a, 0, a.length - 1, aux);
    }

    private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);           // Sort left half.
        sort(a, mid + 1, hi, aux);       // Sort right half.
        merge(a, lo, mid, hi, aux);      // Merge results.
    }

    @SuppressWarnings("GrazieInspection")
    public static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)           // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];        // left half exhausted (take from the right)
            else if (j > hi) a[k] = aux[i++];    // right half exhausted (take from the left)
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
