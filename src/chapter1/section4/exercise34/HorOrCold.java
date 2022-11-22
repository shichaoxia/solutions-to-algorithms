package chapter1.section4.exercise34;

public class HorOrCold {
    private final int N;
    private final int goal;

    private Integer previousGuess = null;

    public HorOrCold(int N, int goal) {
        this.N = N;
        this.goal = goal;
    }

    public int searchSimTwoLgN() {
        return searchSimTwoLgN(1, N);
    }

    private int searchSimTwoLgN(int lo, int hi) {
        if (lo == hi) return lo;

        int mid = (lo + hi) / 2;

        GuessResult firstGuess = guess(lo);

        if (firstGuess == GuessResult.HIT) return lo;

        GuessResult secondGuess = guess(hi);

        return switch (secondGuess) {
            case HIT -> hi;
            case HOTTER -> searchSimTwoLgN(mid + 1, hi);
            case NOT_HOTTER -> searchSimTwoLgN(lo, mid);
            default -> throw new IllegalStateException("Unexpected value: " + secondGuess);
        };
    }

    public int searchSimOneLgN() {
        GuessResult guessFirst = guess(1);

        if (guessFirst == GuessResult.HIT) return 1;

        int mid = (1 + N) / 2;

        GuessResult guessLast = guess(N);

        return switch (guessLast) {
            case HIT -> N;
            case HOTTER -> searchSimOneLgN(mid, N);
            case NOT_HOTTER -> searchSimOneLgN(1, mid);
            default -> throw new IllegalStateException("Unexpected value: " + guessLast);
        };
    }

    private int searchSimOneLgN(int lo, int hi) {
        if (lo + 1 == hi) return guess(lo) == GuessResult.HIT ? lo : hi;

        int mid = (lo + hi) / 2;

        int currentGuess = previousGuessSymmetry((lo + hi) / 2);

        boolean currentGuessOnRight = currentGuess > previousGuess;

        GuessResult result = guess(currentGuess);

        return switch (result) {
            case HOTTER -> currentGuessOnRight ? searchSimOneLgN(mid, hi) : searchSimOneLgN(lo, mid);
            case NOT_HOTTER -> currentGuessOnRight ? searchSimOneLgN(lo, mid) : searchSimOneLgN(mid, hi);
            default -> throw new IllegalStateException("Unexpected value: " + result);
        };
    }

    private int previousGuessSymmetry(int mid) {
        if (previousGuess > mid) return mid - (previousGuess - mid);
        else return mid + (mid - previousGuess);
    }

    private GuessResult guess(int x) {
        Integer previousGuessCopy = previousGuess;
        previousGuess = x;
        if (x == goal) return GuessResult.HIT;
        else if (previousGuessCopy == null) return GuessResult.FIRST_GUESS;
        else if (isCloser(x, previousGuessCopy)) return GuessResult.HOTTER;
        else return GuessResult.NOT_HOTTER;
    }

    private boolean isCloser(int x, int previous) {
        return Math.abs(goal - x) < Math.abs(goal - previous);
    }

    private enum GuessResult {
        HIT, FIRST_GUESS, HOTTER, NOT_HOTTER
    }
}
