package ch1.sec1.ex2;

public class Ex2 {
    public static Double a() {
        return (1 + 2.236) / 2;
    }

    public static Double b() {
        return 1 + 2 + 3 + 4.0;
    }

    @SuppressWarnings("ConstantValue")
    public static Boolean c() {
       return 4.1 >= 4;
    }

    public static String d() {
        return 1 + 2 + "3";
    }
}
