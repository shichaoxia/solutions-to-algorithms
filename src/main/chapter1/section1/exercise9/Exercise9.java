package chapter1.section1.exercise9;

public class Exercise9 {
    public static String convertIntToBinaryString(int N) {
        StringBuilder s = new StringBuilder();
        for (int n = N; n > 0; n /= 2)
            s.insert(0, (n % 2));
        return s.toString();
    }
}
