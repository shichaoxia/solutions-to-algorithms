package chapter2.section2.exercise27;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy"})
public class Merge {

    private static final Map<Integer, List<Integer>> stat = new HashMap<>();
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
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
            aux[k] = a[k];

        int N = hi - lo + 1;
        boolean exhausted = false;
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)
            if (i > mid) {
                a[k] = aux[j++];
                if (!exhausted) {
                    store(N, hi - j + 1);
                    exhausted = true;
                }
            } else if (j > hi) {
                a[k] = aux[i++];
                if (!exhausted) {
                    store(N, hi - i + 1);
                    exhausted = true;
                }
            } else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void store(int N, int length) {
        if (!stat.containsKey(N)) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(length);
            stat.put(N, l);
        } else {
            stat.get(N).add(length);
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        List<Map<Integer, Integer>> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            sort(randomArray(1_000_000));
            results.add(NAndLength());
        }
        StdOut.println(average(results));
    }

    public static Map<Integer, Integer> average(List<Map<Integer, Integer>> results) {
        Set<Integer> keys = new HashSet<>();
        for (Map<Integer, Integer> map : results) {
            keys.addAll(map.keySet());
        }

        Map<Integer, Integer> resultMap = new TreeMap<>();
        for (int key : keys) {
            double sum = 0;
            int count = 0;
            for (Map<Integer, Integer> map : results) {
                if (map.containsKey(key)) {
                    sum += map.get(key);
                    count++;
                }
            }
            int average = (int) (sum / count);
            resultMap.put(key, average);
        }
        return resultMap;
    }

    public static Map<Integer, Integer> NAndLength() {
        Map<Integer, Integer> results = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : stat.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();

            int sum = 0;
            for (int i : value) {
                sum += i;
            }

            int average = sum / value.size();
            results.put(key, average);
        }
        return results;
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++)
            a[i] = StdRandom.uniform();
        return a;
    }
}
