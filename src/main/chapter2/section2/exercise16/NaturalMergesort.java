package chapter2.section2.exercise16;

@SuppressWarnings({"rawtypes", "unchecked"})
public class NaturalMergesort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int mid = findSortedSubarray(a, 0);
        merge(a, mid);
    }

    public static int findSortedSubarray(Comparable[] a, int lo) {
        int hi = lo;
        while (hi + 1 < a.length && lessEq(a[hi], a[hi + 1]))
            hi += 1;
        return hi;
    }

    public static void merge(Comparable[] a, int mid) {
        if (mid == a.length - 1)
            return;
        int hi = findSortedSubarray(a, mid + 1);
        merge(a, 0, mid, hi);
        merge(a, hi);
    }

    @SuppressWarnings({"DuplicatedCode", "ManualArrayCopy", "GrazieInspection"})
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean lessEq(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

}
