package ch1.sec1.ex24;

public class Ex24 {
    public static int gcd(int p, int q) {
        System.out.println("p: " + p + ", q: " + q);
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.printf("GCD of %d and %d is %d%n", p, q, gcd(p, q));
    }
}
