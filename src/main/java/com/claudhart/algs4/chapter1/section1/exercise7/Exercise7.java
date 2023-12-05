package com.claudhart.algs4.chapter1.section1.exercise7;

public class Exercise7 {
    public static String a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) t = (9.0 / t + t) / 2.0;
        return String.format("%.5f\n", t);
    }

    public static int b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        return sum;
    }

    public static int c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        return sum;
    }
}
