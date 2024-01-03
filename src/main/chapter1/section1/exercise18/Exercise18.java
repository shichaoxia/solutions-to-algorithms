package chapter1.section1.exercise18;

public class Exercise18 {
    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }
    public static int mystery2(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) * a;
    }
}
