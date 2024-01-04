package ch1.sec1.ex9;

public class Ex9 {
    public static String convertIntToBinaryString(int N) {
        StringBuilder s = new StringBuilder();
        for (int n = N; n > 0; n /= 2)
            s.insert(0, (n % 2));
        return s.toString();
    }
}
