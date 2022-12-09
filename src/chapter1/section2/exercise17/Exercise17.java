package chapter1.section2.exercise17;

public class Exercise17 {

    public static class Rational {
        private final long numerator;
        private final long denominator;

        public Rational(long numerator, long denominator) {
            if (denominator == 0)
                throw new ArithmeticException();

            long n = Math.absExact(numerator);
            long d = Math.absExact(denominator);
            LongPair lp = simplify(n, d);

            if (numerator < 0 && denominator < 0)
                this.numerator = lp.a;
            else if (numerator < 0 || denominator < 0)
                this.numerator = Math.negateExact(lp.a);
            else
                this.numerator = lp.a;
            this.denominator = lp.b;
        }

        public long numerator() {
            return numerator;
        }

        public long denominator() {
            return denominator;
        }

        public Rational plus(Rational b) {
            return new Rational(Math.addExact(Math.multiplyExact(this.numerator, b.denominator),
                    Math.multiplyExact(b.numerator, this.denominator)),
                    Math.multiplyExact(this.denominator, b.denominator));
        }

        public Rational minus(Rational b) {
            return new Rational(
                    Math.subtractExact(Math.multiplyExact(this.numerator, b.denominator),
                            Math.multiplyExact(b.numerator, this.denominator)),
                    Math.multiplyExact(this.denominator, b.denominator));
        }

        public Rational times(Rational b) {
            return new Rational(Math.multiplyExact(this.numerator, b.numerator),
                    Math.multiplyExact(this.denominator, b.denominator));
        }

        public Rational divides(Rational b) {
            return this.times(b.reciprocal());
        }

        @Override
        public boolean equals(Object other) {
            if (other == this)
                return true;
            if (other == null)
                return false;
            if (other.getClass() != this.getClass())
                return false;
            Rational that = (Rational) other;
            return this.numerator == that.numerator && this.denominator == that.denominator;
        }

        @Override
        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        private static LongPair simplify(long a, long b) {
            long d = gcd(a, b);
            if (d == 1)
                return new LongPair(a, b);
            return simplify(a / d, b / d);
        }

        private static long gcd(long p, long q) {
            if (q == 0)
                return p;
            long r = p % q;
            return gcd(q, r);
        }

        private Rational reciprocal() {
            return new Rational(this.denominator, this.numerator);
        }
    }

    public static record LongPair(long a, long b) {
    }

}
