package chapter1.section1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Exercise35Test {
    @Test
    void testSimulateDiceRoll() {
        double[] dist1 = Exercise35.diceProbability();
        double[] dist2 = Exercise35.simulateDiceRoll(1000000);
        for (int i = 0; i < dist1.length; i++) {
            assertTrue(Math.abs(dist1[i] - dist2[i]) < 0.001);
        }
    }
}
