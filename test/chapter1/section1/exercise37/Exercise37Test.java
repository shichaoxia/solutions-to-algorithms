package chapter1.section1.exercise37;

import java.util.Arrays;

import chapter1.section1.exercise36.Exercise36;
import org.junit.jupiter.api.Test;

public class Exercise37Test {
    static int M = 4;
    static int N = 1000000;

    @Test
    void testAwfulShuffle() {
        int[][] stats = Exercise36.shuffleStats(M, N, Exercise37::awfulShuffle);
        for (int[] row : stats) {
            System.out.println(Arrays.toString(row));
        }
    }
}
