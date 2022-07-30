package chapter1.section1;

public class Exercise14 {
    public static int lg(int N) {
        return recurLg(N, 1, 0);
    }

    static int recurLg(int N, int product, int result) {
        if (2 * product > N) {
            return result;
        } else {
            return recurLg(N, 2 * product, result + 1);
        }
    }
}
