package ch1.sec4.ex15;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TwoSumFaster {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        int zeroCnt = 0;
        Map<Integer, Integer> am = new ConcurrentHashMap<>();
        for (int i = 0; i < N; i++) {
            am.put(i, a[i]);
            if (a[i] == 0)
                zeroCnt += 1;
        }
        for (int j : a) {
            if (am.containsValue(-j)) {
                cnt += 1;
                // Remove the element being looked up to prevent it from being counted again
                // later
                remove(am, j);
            }
        }
        if (zeroCnt == 0)
            return cnt;
        else
            return cnt - 1;
    }

    private static void remove(Map<Integer, Integer> map, int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                map.remove(entry.getKey());
                // IMPORTANT, otherwise all duplicate elements will be deleted
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { -2, -1, -1, -1, 1, 2, 3, 4 };
        assert count(a) == 4;
        int[] b = { -2, -1, -1, -1, 0, 0, 0, 1, 2, 3, 4 };
        assert count(b) == 6;
    }
}
