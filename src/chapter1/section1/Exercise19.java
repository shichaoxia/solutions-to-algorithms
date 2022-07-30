package chapter1.section1;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {

    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return F(N - 1) + F(N - 2);
    }

    static Map<Integer, Long> temp = new HashMap<>();

    public static Long memorizedF(int N) {
        if (temp.get(N) != null)
            return temp.get(N);
        Long result = Long.valueOf(F(N));
        temp.put(N, result);
        return result;
    }

    final static int repetitions = 25;

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            Exercise19.F(i);
        }

        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        System.out.println(durationInNano);

        long startTime2 = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            Exercise19.memorizedF(i);
        }

        long endTime2 = System.nanoTime();
        long durationInNano2 = (endTime2 - startTime2);
        System.out.println(durationInNano2);
    }

}

class Fibonacci {
    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return F(N - 1) + F(N - 2);

    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
    }
}
