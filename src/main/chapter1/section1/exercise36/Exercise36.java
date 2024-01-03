package chapter1.section1.exercise36;

import java.util.function.Consumer;

public class Exercise36 {
    public static int[][] shuffleStats(int M, int N, Consumer<int[]> shuffle) {
        int[] a = new int[M];
        int[][] stats = new int[M][M];
        for (int j = 0; j < N; j++) {
            init(a);
            shuffle.accept(a);
            for (int i = 0; i < a.length; i++)
                stats[a[i]][i] += 1;
        }
        return stats;
    }

    static void init(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }
}
