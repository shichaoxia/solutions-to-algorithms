package chapter2.section1.exercise38;

import edu.princeton.cs.algs4.*;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static StringKeyOneDoubleValue[] stringKeyOneDoubleValue(int N) {
        StringKeyOneDoubleValue[] a = new StringKeyOneDoubleValue[N];
        for (int i = 0; i < N; i++) a[i] = new StringKeyOneDoubleValue();
        return a;
    }

    public static DoubleKeyTenStringValues[] doubleKeyTenStringValues(int N) {
        DoubleKeyTenStringValues[] a = new DoubleKeyTenStringValues[N];
        for (int i = 0; i < N; i++) a[i] = new DoubleKeyTenStringValues();
        return a;
    }

    public static IntKeyOneIntArrayValue[] intKeyOneIntArrayValue(int N) {
        IntKeyOneIntArrayValue[] a = new IntKeyOneIntArrayValue[N];
        for (int i = 0; i < N; i++) a[i] = new IntKeyOneIntArrayValue();
        return a;
    }

    public static String randomString(int length) {
        @SuppressWarnings("SpellCheckingInspection")
        String alphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        StringBuilder s = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int ch = (int) (alphaNumericStr.length() * Math.random());
            s.append(alphaNumericStr.charAt(ch));
        }
        return s.toString();
    }

    public static Comparable[] generateArray(String arrayCase, int N) {
        return switch (arrayCase) {
            case "stringKeyOneDoubleValue" -> stringKeyOneDoubleValue(N);
            case "doubleKeyTenStringValues" -> doubleKeyTenStringValues(N);
            case "intKeyOneIntArrayValue" -> intKeyOneIntArrayValue(N);
            default -> null;
        };
    }

    public static void doublingTest(String alg, String arrayCase) {
        StdOut.printf("%s ", arrayCase);
        StdOut.println(alg);
        StdOut.printf("%10s %10s %10s%n", "N", "time", "ratio");
        int N = 250;
        Comparable[] a = generateArray(arrayCase, N);
        double previous = time(alg, a);
        for (N = 500; N <= 64_000; N += N) {
            a = generateArray(arrayCase, N);
            double time = time(alg, a);
            double ratio = time / previous;
            previous = time;
            StdOut.printf("%10d %10.3f %10.1f%n", N, time, ratio);
        }
    }

    public static void main(String[] args) {
        String[] arrayCases = {"stringKeyOneDoubleValue", "doubleKeyTenStringValues", "intKeyOneIntArrayValue"};
        String[] algs = {"Selection", "Insertion", "Shell"};
        for (String arrayCase : arrayCases)
            for (String alg : algs) doublingTest(alg, arrayCase);
    }

}
