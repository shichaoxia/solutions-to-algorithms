package ch2.sec1.ex29;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Shell29 {

    public static void sort(Comparable[] a) {
        int N = a.length;
        // 0 is for terminating the loop
        int[] increments = {0, 1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};
        int k = 1;
        int h = increments[k];
        while (h < N / 3) h = increments[++k];
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = increments[--k];
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
