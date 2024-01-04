package ch1.sec5.ex18;

import ch1.sec3.ex34.RandomBag;
import edu.princeton.cs.algs4.StdOut;

public class RandomGridGenerator {
    public static Connection[] generate(int N) {
        RandomBag<Connection> randomBag = new RandomBag<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                randomBag.add(new Connection(i, j));
        Connection[] connections = new Connection[randomBag.size()];
        int idx = 0;
        for (Connection c : randomBag)
            connections[idx++] = c;
        return connections;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Connection[] connections = generate(N);
        for (Connection c : connections) {
            StdOut.println(c.p + " " + c.q);
        }
    }

}
