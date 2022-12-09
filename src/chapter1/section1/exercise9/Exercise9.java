package chapter1.section1.exercise9;

public class Exercise9 {
    public static String convertIntToBinaryString(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        return s;
    }
}
