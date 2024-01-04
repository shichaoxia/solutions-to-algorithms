package ch1.sec1.ex20;

public class Ex20 {
    public static double logFact(int N) {
        if (N == 1)
            return 0;
        return Math.log(N) + logFact(N - 1);
    }
}
