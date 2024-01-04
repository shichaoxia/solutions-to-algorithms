package ch1.sec1.ex35;

import edu.princeton.cs.algs4.StdRandom;

public class Ex35 {
    public static double[] diceProbability() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }

    public static double[] simulateDiceRoll(int N) {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 0; i < N; i++) {
            int side1 = StdRandom.uniform(1, 7);
            int side2 = StdRandom.uniform(1, 7);
            dist[side1 + side2] += 1;
        }
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= N;
        return dist;
    }
}
