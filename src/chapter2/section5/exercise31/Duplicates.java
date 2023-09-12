package chapter2.section5.exercise31;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Duplicates {
    public static int[] generateRandomValues(int N, int M) {
        int[] values = new int[N];
        for (int i = 0; i < N; i++)
            values[i] = StdRandom.uniform(0, M);
        return values;
    }

    public static int duplicatesNum(int[] values) {
        Arrays.sort(values);
        int duplicatesNum = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) duplicatesNum++;
        }
        return duplicatesNum;
    }

    public static double duplicatesRatio(int N, int M) {
        double ratio = 0;
        int[] values;
        for (int T = 0; T < 10; T++) {
            values = generateRandomValues(N, M);
            ratio += (double) duplicatesNum(values) / N;
        }
        return ratio / 10;
    }

    public static double theoryRatio(double a) {
        return 1 - Math.pow(Math.E, -a);
    }

    public static void main(String[] args) {
        System.out.printf("%22s %10s %10s %10s %10s%n", "M, theory \\ actual / N", "10^3", "10^4", "10^5", "10^6");
        double[] alphas = {2, 1, 0.5};
        for (double a : alphas)
            trial(a);
    }

    public static void trial(double a) {
        System.out.printf("%22s", String.format("N/%2.1f", a) + String.format(", %4.2f", theoryRatio(a)));
        for (int N = 1_000; N <= 1_000_000; N *= 10)
            System.out.printf(" %10.3f", duplicatesRatio(N, (int) (N / a)));
        System.out.println();
    }
}
