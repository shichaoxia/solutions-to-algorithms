package ch2.sec1.ex24;

@SuppressWarnings({"rawtypes", "unchecked"})
public class InsertionSentinel {

    public static void sort(Comparable[] a) {
        exchangeSmallestToFirst(a);
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void exchangeSmallestToFirst(Comparable[] a) {
        int smallestIndex = 0;
        Comparable smallest = a[smallestIndex];
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(smallest) < 0) {
                smallestIndex = i;
                smallest = a[i];
            }
        }
        exch(a, 0, smallestIndex);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

}
