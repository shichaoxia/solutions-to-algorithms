package ch1.sec1.ex8;

public class Ex8 {
    public static String a() {
        return Character.toString('b');
    }

    public static String b() {
        return Character.toString('b' + 'c');
    }

    public static String c() {
        return Character.toString((char) ('a' + 4));
    }
}
