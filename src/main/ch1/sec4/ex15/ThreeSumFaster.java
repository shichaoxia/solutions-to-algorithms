package ch1.sec4.ex15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"DuplicatedCode", "InfiniteLoopStatement"})
public class ThreeSumFaster {
    @SuppressWarnings("UnusedReturnValue")
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;

        List<Map<Integer, Integer>> maps = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < N; j++) {
                map.put(j, a[j]);
            }
            maps.add(map);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (j + 1 < N && maps.get(j + 1).containsValue(-a[i] - a[j])) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    
    public static void test() {
        int[] a = { -2, -1, -1, -1, 0, 1, 1, 2, 3, 4 };
        count(a);
        StdOut.println("");
        int[] b = { -2, -1, -1, -1, 0, 0, 0, 1, 2, 3, 4 };
        count(b);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static double timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        count(a);
        Arrays.binarySearch(a, 1);
        return timer.elapsedTime();
    }

    private static void timeTest() {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }

    public static void main(String[] args) {
        timeTest();
    }
}
