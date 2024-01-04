package ch2.sec2.ex28;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy", "DuplicatedCode"})
public class MergeBU {
    private static Comparable[] aux;
    public static Map<Integer, Integer> stat;

    public static void sort(Comparable[] a) {
        stat = new TreeMap<>();
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2)            
            for (int lo = 0; lo < N - sz; lo += 2 * sz)  
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        statIncrease(hi - lo + 1);
        
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)           
            if (i > mid) a[k] = aux[j++];        
            else if (j > hi) a[k] = aux[i++];    
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void statIncrease(int N) {
        if (!stat.containsKey(N)) {
            stat.put(N, 1);
        } else {
            stat.put(N, stat.get(N) + 1);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
