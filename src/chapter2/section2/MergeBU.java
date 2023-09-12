package chapter2.section2;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
public class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // Do lg N passes of pairwise merges.
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2)            // sz: subarray size
            for (int lo = 0; lo < N - sz; lo += 2 * sz)  // lo: subarray index
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
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

