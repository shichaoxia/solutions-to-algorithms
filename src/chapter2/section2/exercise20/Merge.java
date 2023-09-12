package chapter2.section2.exercise20;

@SuppressWarnings({"rawtypes", "ManualArrayCopy", "unchecked"})
public class Merge {
    
    private static int[] aux;
    private static int[] perm;

    // tag::snippet[]
    public static int[] sort(Comparable[] a) {
        aux = new int[a.length];
        perm = new int[a.length];
        for (int i = 0; i < a.length; i++) perm[i] = i;
        sort(a, 0, a.length - 1);
        return perm;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = perm[k];

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)
            if (i > mid) perm[k] = aux[j++];
            else if (j > hi) perm[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]])) perm[k] = aux[j++];
            else perm[k] = aux[i++];
    }
    // end::snippet[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
